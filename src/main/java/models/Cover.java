package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

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

    private int height;

    private int width;

    private String articul_new;

    private String  title_new;


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

    @Override
    public String toString() {
        return "Cover{" +
                "id=" + id +
                ", mass=" + mass +
                ", length=" + length +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

}