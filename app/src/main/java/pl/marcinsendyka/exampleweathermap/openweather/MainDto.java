package pl.marcinsendyka.exampleweathermap.openweather;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MainDto {
    private final String temp;

    @JsonCreator
    public MainDto(@JsonProperty("temp") String temp) {
        this.temp = temp;
    }

    public String getTemp() {
        return temp;
    }
}
