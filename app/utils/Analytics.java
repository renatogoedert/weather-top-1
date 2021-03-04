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
      station.maxTemp = Analytics.maxTemp(station.readings);
      station.minTemp = Analytics.minTemp(station.readings);
      station.windBft = Conversion.beafourt(lastReading.windSpeed);
      station.maxWind = Analytics.maxWind(station.readings);
      station.minWind = Analytics.minWind(station.readings);
      station.pressure = lastReading.pressure;
      station.maxPressure = Analytics.maxPressure(station.readings);
      station.minPressure = Analytics.minPressure(station.readings);
      String str = String.format("%1.2f", Analytics.windChill(lastReading.temperature, lastReading.windSpeed));
      station.windChill = Double.valueOf(str);
      station.windCompass = Conversion.degreesToCompass(lastReading.windDirection);
    }
  }

  public static double windChill(double temp, double windspeed) {
    return 13.12 + 0.6215 * temp -  11.37 * (Math.pow(windspeed, 0.16)) + 0.3965 * temp * (Math.pow(windspeed, 0.16));
  }

  public static double max(double values[]) {
    double max = values[0];
    for (double value : values) {
      if (value > max) {
        max = value;
      }
    }
    return max;
  }

  public static double min(double values[]) {
    double min = values[0];
    for (double value : values) {
      if (value < min) {
        min = value;
      }
    }
    return min;
  }

  public static double maxTemp(List<Reading> readings) {
    double values[] = new double[readings.size()];
    for (int i=0; i<readings.size(); i++) values[i] = readings.get(i).temperature;
    return max(values);
  }

  public static double minTemp(List<Reading> readings) {
    double values[] = new double[readings.size()];
    for (int i=0; i<readings.size(); i++) values[i] = readings.get(i).temperature;
    return min(values);
  }

  public static double maxWind(List<Reading> readings) {
    double values[] = new double[readings.size()];
    for (int i=0; i<readings.size(); i++) values[i] = readings.get(i).windSpeed;
    return max(values);
  }

  public static double minWind(List<Reading> readings) {
    double values[] = new double[readings.size()];
    for (int i=0; i<readings.size(); i++) values[i] = readings.get(i).windSpeed;
    return min(values);
  }

  public static double maxPressure(List<Reading> readings) {
    double values[] = new double[readings.size()];
    for (int i=0; i<readings.size(); i++) values[i] = readings.get(i).pressure;
    return max(values);
  }

  public static double minPressure(List<Reading> readings) {
    double values[] = new double[readings.size()];
    for (int i=0; i<readings.size(); i++) values[i] = readings.get(i).pressure;
    return min(values);
  }

}
