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
    render ("dashboard.html", stations);
  }

  public static void addStation (String name)
  {
    Logger.info("Adding a Station");
    Station station = new Station(name);
    station.save();
    redirect ("/dashboard");
  }
}
