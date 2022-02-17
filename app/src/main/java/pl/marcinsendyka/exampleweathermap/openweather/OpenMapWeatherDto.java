package pl.marcinsendyka.exampleweathermap.openweather;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenMapWeatherDto {
    private final String name;
    private final String dt;
    private final MainDto main;

    @JsonCreator
    public OpenMapWeatherDto(
            @JsonProperty("name") String name,
            @JsonProperty("dr") String dt,
            @JsonProperty("main") MainDto main) {
        this.name = name;
        this.dt = dt;
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public String getDt() {
        return dt;
    }

    public MainDto getMain() {
        return main;
    }
}
