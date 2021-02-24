package utils;

import models.Reading;
import models.Station;

import java.util.List;

public class Analytics {
  public static void updateWeather(Station station) {
    if (station.readings.size() > 0) {
      Reading lastReading = station.readings.get(station.readings.size() - 1);
      station.code = lastReading.code;
      station.weather = Conversion.currentWeather(lastReading.code);
      station.tempC = lastReading.temperature;
      station.tempF = Conversion.tempF(lastReading.temperature);
      station.windBft = Conversion.beafourt(lastReading.windSpeed);
      station.pressure = lastReading.pressure;
    }
  }
}
