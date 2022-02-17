package pl.marcinsendyka.exampleweathermap;

import java.time.ZonedDateTime;

public class WeatherData {

    private final String city;
    private final ZonedDateTime date;
    private final double tempInCelcius;

    public WeatherData(String city, ZonedDateTime date, double tempInCelcius) {
        this.city = city;
        this.date = date;
        this.tempInCelcius = tempInCelcius;
    }

    public String getCity() {
        return city;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public double getTempInCelcius() {
        return tempInCelcius;
    }
}
