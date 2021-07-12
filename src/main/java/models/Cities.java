package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cities", schema = "public")
public class Cities {
    @Id
    private int id;

    public int getId() {
        return id;
    }

    @Column(name = "city")
    private String city;
    @Column(name = "region_id")
    private int region_id;
    @Column(name = "snowarea")
    private int snowarea;
    @Column(name = "windarea")
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
