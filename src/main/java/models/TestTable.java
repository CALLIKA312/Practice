package models;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;
import services.TestTableService;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;


@Entity
@Table(name = "public.table")
public class TestTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int index;

    /*private int setIndex() {
        int index = 1;
        List<TestTable> testTableList = TestTableService.getAll();
        testTableList.sort(Comparator.comparingInt(TestTable::getIndex));
        int curIndexInList = 0;
        while (true) {
            if (index < testTableList.get(curIndexInList).getIndex()) {
                return index;
            }
            curIndexInList++;
            index++;
            if (index > testTableList.size()) {
                return index;
            }
        }
    }*/

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
        //this.index = setIndex();
        this.name = name;
        this.value = value;
    }

    public TestTable(int index, String name, int value) {
        this.index = index;
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
