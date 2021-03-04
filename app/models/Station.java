package models;

import play.db.jpa.Model;
import utils.Conversion;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Station extends Model
{
  public String name;

  public int code;
  public String weather;
  public double tempC, tempF;
  public double maxTemp, minTemp;
  public int windBft;
  public int pressure;
  public double windChill;
  public String windCompass;

  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();

  public Station(String name)
  {
    this.name = name;
  }

  public String weatherIcon() {
    return Conversion.weatherIcon(this.code);
  }
}