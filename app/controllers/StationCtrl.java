package controllers;

import models.Station;
import play.Logger;
import play.mvc.Controller;
import utils.Analytics;

public class StationCtrl extends Controller
{
  public static void index(Long id)
  {
    Logger.info("Rendering Dashboard");
    Station station = Station.findById(id);
    Analytics.updateWeather(station);
    render("station.html", station);
  }
}
