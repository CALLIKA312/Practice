package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "trays", schema = "public")
public class Trays {
    @Id
    private int id;

    public int getId() {
        return id;
    }

    private int height;
    private int width;
    private int length;
    private double thickness;
    private int mass;
    private String articul_new;
    private int type;

    @Transient
    public double suitability;

    public Trays() {
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public String getArticul_new() {
        return articul_new;
    }

    public void setArticul_new(String articul_new) {
        this.articul_new = articul_new;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Trays{" +
                "id=" + id +
                ", height=" + height +
                ", width=" + width +
                ", length=" + length +
                ", cover_type_id=" + thickness +
                ", mass=" + mass +
                ", articul_new='" + articul_new + '\'' +
                '}';
    }
}
