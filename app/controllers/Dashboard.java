package controllers;

import models.Station;
import play.Logger;
import play.mvc.Controller;
import utils.Analytics;

import java.util.List;

public class Dashboard extends Controller
{
  public static void index() {
    Logger.info("Rendering Dashboard");
    List<Station> stations = Station.findAll();
    for (Station station : stations) {
      Analytics.updateWeather(station);
    }
    render ("dashboard.html", stations);
  }
}
