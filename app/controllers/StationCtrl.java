package controllers;

import models.Reading;
import models.Station;
import play.Logger;
import play.mvc.Controller;
import utils.Analytics;

public class StationCtrl extends Controller {
  public static void index(Long id) {
    Logger.info("Rendering Dashboard");
    Station station = Station.findById(id);
    Analytics.updateWeather(station);
    render("station.html", station);
  }

  public static void addReading(Long id, int code, double temperature, double windSpeed, int windDirection,
                                int pressure) {
    Logger.info("Adding a Reading");
    Station station = Station.findById(id);
    Reading reading = new Reading(code, temperature, windSpeed, windDirection, pressure);
    station.readings.add(reading);
    Analytics.updateWeather(station);
    station.save();
    redirect("/stations/" + id);
  }
}
