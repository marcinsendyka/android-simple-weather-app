package pl.marcinsendyka.exampleweathermap.openweather;

import feign.Param;
import feign.RequestLine;

public interface OpenWeatherMapClient {

    @RequestLine("GET /data/2.5/weather?q={city}&appid={apiKey}&units=metric")
    OpenMapWeatherDto getWeather(@Param("city") String city, @Param("apiKey") String apiKey);
}
