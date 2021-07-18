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

    private int length;

    private int type;

    private int width;

    private double thickness;

    private String articul_new;

    private String title_new;


    public Cover() {
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getType() {
        return type;
    }

    public void setType(int height) {
        this.type = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getArticul_new() {
        return articul_new;
    }

    public void setArticul_new(String articul_new) {
        this.articul_new = articul_new;
    }

    public String getTitle_new() {
        return title_new;
    }

    public void setTitle_new(String title_new) {
        this.title_new = title_new;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    @Override
    public String toString() {
        return "Cover{" +
                "id=" + id +
                ", mass=" + mass +
                ", length=" + length +
                ", type=" + type +
                ", width=" + width +
                ", thickness=" + thickness +
                ", articul_new='" + articul_new + '\'' +
                ", title_new='" + title_new + '\'' +
                '}';
    }
}