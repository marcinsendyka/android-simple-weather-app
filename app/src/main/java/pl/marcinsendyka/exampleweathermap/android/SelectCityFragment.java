package pl.marcinsendyka.exampleweathermap.android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import pl.marcinsendyka.exampleweathermap.R;
import pl.marcinsendyka.exampleweathermap.databinding.FragmentFirstBinding;

public class SelectCityFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.showWeatherButton.setOnClickListener(view1 -> {
            handleOnShowWeather();
        });
    }

    private void handleOnShowWeather() {
        binding.validationTextView.setText("");
        String city = binding.city.getText().toString();
        if (city.isEmpty()) {
            binding.validationTextView.setText(R.string.invalid_city_error_message);
        } else {

            Bundle result = new Bundle();
            result.putString("city", city);
            getParentFragmentManager().setFragmentResult("city", result);
            NavHostFragment.findNavController(SelectCityFragment.this)
                    .navigate(R.id.action_FirstFragment_to_SecondFragment);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}