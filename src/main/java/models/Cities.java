package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cities", schema = "public")
public class Cities {
    @Id
    private int id;

    public int getId() {
        return id;
    }

    private String city;
    private int region_id;
    private int snowarea;
    private int windarea;


    public Cities() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public int getSnowarea() {
        return snowarea;
    }

    public void setSnowarea(int snowarea) {
        this.snowarea = snowarea;
    }

    public int getWindarea() {
        return windarea;
    }

    public void setWindarea(int windarea) {
        this.windarea = windarea;
    }

    @Override
    public String toString() {
        return city;
    }
}
