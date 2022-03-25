package com.xiaoxiong.al;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class TestPojo implements Comparable {
    private String name;
    private String age;
    private String salary;

    @Override
    public String toString() {
        return "TestPojo{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }


    @Override
    public int compareTo(Object o) {

        TestPojo o1 = (TestPojo) o;

        int compare = this.getAge().compareTo(((TestPojo) o).getAge());

        return compare;
    }
}
