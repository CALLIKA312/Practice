package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cables", schema = "public")
public class Cables {
    @Id
    private int id;

    public int getId() {
        return id;
    }

    private String articul;
    private int diametr;
    private int mass;
    private String voltage;

    public String getArticul() {
        return articul;
    }

    public void setArticul(String articul) {
        this.articul = articul;
    }

    public int getDiametr() {
        return diametr;
    }

    public void setDiametr(int diametr) {
        this.diametr = diametr;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }



    @Override
    public String toString() {
        return "Cables{" +
                "id=" + id +
                ", articul='" + articul + '\'' +
                ", diametr=" + diametr +
                ", mass=" + mass +
                ", voltage='" + voltage + '\'' +
                '}';
    }
}
