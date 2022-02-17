package pl.marcinsendyka.exampleweathermap;

import java.util.concurrent.Callable;

public class WeatherTask implements Callable<WeatherData> {

    private final WeatherProvider weatherProvider;
    private final String city;

    public WeatherTask(WeatherProvider weatherProvider, String city) {
        this.weatherProvider = weatherProvider;
        this.city = city;
    }

    @Override
    public WeatherData call() {
        return weatherProvider.getFor(city);
    }
}
