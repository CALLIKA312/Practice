package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "snowLoads", schema = "public")
public class SnowLoads {
    @Id
    private int area;

    public int getArea() {
        return area;
    }
    private int load_n;
    private int load_r;

    public SnowLoads() {
    }

    public int getLoad_n() {
        return load_n;
    }

    public void setLoad_n(int load_n) {
        this.load_n = load_n;
    }

    public int getLoad_r() {
        return load_r;
    }

    public void setLoad_r(int load_r) {
        this.load_r = load_r;
    }

    @Override
    public String toString() {
        return String.valueOf(area);
    }
}

