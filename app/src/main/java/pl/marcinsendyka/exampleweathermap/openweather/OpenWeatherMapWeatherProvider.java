package pl.marcinsendyka.exampleweathermap.openweather;

import java.time.ZonedDateTime;

import pl.marcinsendyka.exampleweathermap.WeatherData;
import pl.marcinsendyka.exampleweathermap.WeatherProvider;

public class OpenWeatherMapWeatherProvider implements WeatherProvider {
    private final OpenWeatherMapClient openWeatherMapClient;
    private final String apiKey;

    public OpenWeatherMapWeatherProvider(OpenWeatherMapClient openWeatherMapClient, String apiKey) {
        this.openWeatherMapClient = openWeatherMapClient;
        this.apiKey = apiKey;
    }

    @Override
    public WeatherData getFor(String city) {
        OpenMapWeatherDto dto = openWeatherMapClient.getWeather(city, apiKey);

        return map(dto);
    }

    private WeatherData map(OpenMapWeatherDto dto) {
        return new WeatherData(dto.getName(), toZonedDateTime(dto.getDt()), Double.parseDouble(dto.getMain().getTemp()));
    }

    private ZonedDateTime toZonedDateTime(String dt) {
        return ZonedDateTime.now();
    }
}
