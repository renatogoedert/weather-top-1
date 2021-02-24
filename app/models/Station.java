package models;

import play.db.jpa.Model;
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
  public int windBft;
  public int pressure;

  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();

  public Station(String name, double lat, double lng)
  {
    this.name = name;
  }
}