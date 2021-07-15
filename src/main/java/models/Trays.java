package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private int cover_type_id;
    private int mass;
    private String articul_new;

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

    public int getCover_type_id() {
        return cover_type_id;
    }

    public void setCover_type_id(int cover_type_id) {
        this.cover_type_id = cover_type_id;
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

    @Override
    public String toString() {
        return "Trays{" +
                "id=" + id +
                ", height=" + height +
                ", width=" + width +
                ", length=" + length +
                ", cover_type_id=" + cover_type_id +
                ", mass=" + mass +
                ", articul_new='" + articul_new + '\'' +
                '}';
    }
}
