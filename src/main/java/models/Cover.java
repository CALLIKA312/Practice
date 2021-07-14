package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cover", schema = "public")
public class Cover {
    @Id
    private int id;

    public int getId() {
        return id;
    }

    private int mass;

    private String title_display;

    private int construction_id;

    public Cover() {
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public String getTitle_display() {
        return title_display;
    }

    public void setTitle_display(String title_display) {
        this.title_display = title_display;
    }

    public int getConstruction_id() {
        return construction_id;
    }

    public void setConstruction_id(int construction_id) {
        this.construction_id = construction_id;
    }

    @Override
    public String toString() {
        return "Cover{" +
                "id=" + id +
                ", mass=" + mass +
                ", title_display='" + title_display + '\'' +
                ", construction_id=" + construction_id +
                '}';
    }
}
