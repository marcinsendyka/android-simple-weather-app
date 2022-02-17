package pl.marcinsendyka.exampleweathermap.android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import pl.marcinsendyka.exampleweathermap.R;
import pl.marcinsendyka.exampleweathermap.WeatherData;
import pl.marcinsendyka.exampleweathermap.WeatherTask;
import pl.marcinsendyka.exampleweathermap.databinding.FragmentSecondBinding;

public class ShowWeatherFragment extends Fragment {

    public static final String BUNDLE_REQUEST_KEY = "city";
    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener(BUNDLE_REQUEST_KEY, this,
                (requestKey, bundle) -> {
                    String result = bundle.getString(BUNDLE_REQUEST_KEY);
                    Future<WeatherData> submit = ApplicationContext.executorService()
                            .submit(new WeatherTask(ApplicationContext.openWeatherMapWeatherProvider(), result));
                    binding.date.setText(R.string.loading_label);
                    binding.temp.setText(R.string.loading_label);

                    try {
                        WeatherData weatherData = submit.get();
                        binding.cityValue.setText(weatherData.getCity());
                        binding.date.setText(weatherData.getDate().format(DateTimeFormatter.RFC_1123_DATE_TIME));
                        binding.temp.setText(formatTemperature(weatherData.getTempInCelcius()));
                    } catch (ExecutionException | InterruptedException e) {
                        NavHostFragment.findNavController(ShowWeatherFragment.this)
                                .navigate(R.id.action_showWeatherFragment_to_errorFragment);
                    }
                });
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonSecond.setOnClickListener(view1 -> NavHostFragment.findNavController(ShowWeatherFragment.this)
                .navigate(R.id.action_SecondFragment_to_FirstFragment));
    }

    @NonNull
    private String formatTemperature(double temp) {
        return String.format(Locale.ENGLISH, "%.2f \u2103", temp);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}