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
      String str = String.format("%1.2f", Analytics.windChill(lastReading.temperature, lastReading.windSpeed));
      station.windChill = Double.valueOf(str);
      station.windCompass = Conversion.degreesToCompass(lastReading.windDirection);
    }
  }

  public static double windChill(double temp, double windspeed) {
    return 13.12 + 0.6215 * temp -  11.37 * (Math.pow(windspeed, 0.16)) + 0.3965 * temp * (Math.pow(windspeed, 0.16));
  }
}
