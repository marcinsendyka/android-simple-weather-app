package pl.marcinsendyka.exampleweathermap;

import java.time.ZonedDateTime;

public class StubWeatherProvider implements WeatherProvider {
    @Override
    public WeatherData getFor(String city) {
        return new WeatherData(
                "Krakow", ZonedDateTime.now(), 15
        );
    }
}
