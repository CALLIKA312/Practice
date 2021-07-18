package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "traysload", schema = "public")
public class TraysLoad {
    @Id
    private int id;

    public int getId() {
        return id;
    }


    private int trays_type;
    private double step;
    private double ths;

    private double hi25;
    private double hi40;
    private double hi50;
    private double hi60;
    private double hi75;
    private double hi85;
    private double hi100;
    private double hi110;
    private double hi120;
    private double hi150;
    private double hi160;
    private double hi200;
    private double hi70;
    private double hi80;
    private double hi125;
    private double hi175;

    public int getTrays_type() {
        return trays_type;
    }

    public void setTrays_type(int trays_type) {
        this.trays_type = trays_type;
    }

    public double getHi40() {
        return hi40;
    }

    public void setHi40(double hi40) {
        this.hi40 = hi40;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public double getThs() {
        return ths;
    }

    public void setThs(double ths) {
        this.ths = ths;
    }

    public double getHi25() {
        return hi25;
    }

    public void setHi25(double hi25) {
        this.hi25 = hi25;
    }

    public double getHi50() {
        return hi50;
    }

    public void setHi50(double hi50) {
        this.hi50 = hi50;
    }

    public double getHi60() {
        return hi60;
    }

    public void setHi60(double hi60) {
        this.hi60 = hi60;
    }

    public double getHi75() {
        return hi75;
    }

    public void setHi75(double hi75) {
        this.hi75 = hi75;
    }

    public double getHi85() {
        return hi85;
    }

    public void setHi85(double hi85) {
        this.hi85 = hi85;
    }

    public double getHi100() {
        return hi100;
    }

    public void setHi100(double hi100) {
        this.hi100 = hi100;
    }

    public double getHi110() {
        return hi110;
    }

    public void setHi110(double hi110) {
        this.hi110 = hi110;
    }

    public double getHi120() {
        return hi120;
    }

    public void setHi120(double hi120) {
        this.hi120 = hi120;
    }

    public double getHi150() {
        return hi150;
    }

    public void setHi150(double hi150) {
        this.hi150 = hi150;
    }

    public double getHi160() {
        return hi160;
    }

    public void setHi160(double hi160) {
        this.hi160 = hi160;
    }

    public double getHi200() {
        return hi200;
    }

    public void setHi200(double hi200) {
        this.hi200 = hi200;
    }

    public double getHi70() {
        return hi70;
    }

    public void setHi70(double hi70) {
        this.hi70 = hi70;
    }

    public double getHi80() {
        return hi80;
    }

    public void setHi80(double hi80) {
        this.hi80 = hi80;
    }

    public double getHi125() {
        return hi125;
    }

    public void setHi125(double hi125) {
        this.hi125 = hi125;
    }

    public double getHi175() {
        return hi175;
    }

    public void setHi175(double hi175) {
        this.hi175 = hi175;
    }

    @Override
    public String toString() {
        return "TraysLoad{" +
                "id=" + id +
                ", trays_type=" + trays_type +
                ", step=" + step +
                ", ths=" + ths +
                ", hi25=" + hi25 +
                ", hi40=" + hi40 +
                ", hi50=" + hi50 +
                ", hi60=" + hi60 +
                ", hi75=" + hi75 +
                ", hi85=" + hi85 +
                ", hi100=" + hi100 +
                ", hi110=" + hi110 +
                ", hi120=" + hi120 +
                ", hi150=" + hi150 +
                ", hi160=" + hi160 +
                ", hi200=" + hi200 +
                ", hi70=" + hi70 +
                ", hi80=" + hi80 +
                ", hi125=" + hi125 +
                ", hi175=" + hi175 +
                '}';
    }
}
