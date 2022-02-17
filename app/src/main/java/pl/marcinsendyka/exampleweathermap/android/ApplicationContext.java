package pl.marcinsendyka.exampleweathermap.android;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import pl.marcinsendyka.exampleweathermap.BuildConfig;
import pl.marcinsendyka.exampleweathermap.openweather.OpenWeatherMapClient;
import pl.marcinsendyka.exampleweathermap.openweather.OpenWeatherMapWeatherProvider;

public class ApplicationContext {

    public static OpenWeatherMapWeatherProvider openWeatherMapWeatherProvider() {
        return new OpenWeatherMapWeatherProvider(openWeatherMapClient(), BuildConfig.API_KEY);
    }

    private static OpenWeatherMapClient openWeatherMapClient() {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .target(OpenWeatherMapClient.class, "https://api.openweathermap.org");
    }

    public static ExecutorService executorService() {
        return Executors.newSingleThreadExecutor();
    }
}
