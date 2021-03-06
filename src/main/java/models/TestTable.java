package models;

import javax.persistence.*;


@Entity
@Table(name = "public.table")
public class TestTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int index;

    public int getIndex() {
        return index;
    }

    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private int value;


    public TestTable() {
    }

    public TestTable(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "testTable{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
