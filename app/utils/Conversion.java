package utils;

import java.util.HashMap;
import java.util.Map;

public class Conversion {
  static Map<Integer, String> weatherCodes = new HashMap<>();

  static {
    weatherCodes.put(100, "Clear");
    weatherCodes.put(200, "Partial Clouds");
    weatherCodes.put(300, "Cloudy");
    weatherCodes.put(400, "Light Showers");
    weatherCodes.put(500, "Heavy Showers");
    weatherCodes.put(600, "Rain");
    weatherCodes.put(700, "Snow");
    weatherCodes.put(800, "Thunder");
  }

  public static String currentWeather(int code) {
    return weatherCodes.get(code);
  }

  public static double tempF(double tempC) {
    return (tempC * 1.8) + 32;
  }

  public static int beafourt(double windspeed) {
    if (windspeed == 0) {
      return 0;
    } else if (windspeed >= 1 && windspeed <= 6) {
      return 1;
    } else if (windspeed >= 7 && windspeed <= 11) {
      return 2;
    } else if (windspeed >= 12 && windspeed <= 19) {
      return 3;
    } else if (windspeed >= 20 && windspeed <= 29) {
      return 4;
    } else if (windspeed >= 30 && windspeed <= 39) {
      return 5;
    } else if (windspeed >= 40 && windspeed <= 50) {
      return 6;
    } else if (windspeed >= 51 && windspeed <= 62) {
      return 7;
    } else if (windspeed >= 63 && windspeed <= 75) {
      return 8;
    } else if (windspeed >= 76 && windspeed <= 87) {
      return 9;
    } else if (windspeed >= 88 && windspeed <= 102) {
      return 10;
    } else if (windspeed >= 103 && windspeed <= 117) {
      return 11;
    } else if (windspeed >= 117) {
      return 12;
    }
    return -1;
  }
}
