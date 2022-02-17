package pl.marcinsendyka.exampleweathermap;

public interface WeatherProvider {

    WeatherData getFor(String city);
}
