package com.xiaoxiong.al;


import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static List<TestPojo> getPerson() {
        TestPojo testPojo = new TestPojo("mm", "24", "1000");
        TestPojo testPojo1 = new TestPojo("xx", "24", "1234");
        TestPojo testPojo2 = new TestPojo("aa", "24", "4231");
        TestPojo testPojo3 = new TestPojo("bb", "24", "5432");


        List<TestPojo> list = new ArrayList<>();
        list.add(testPojo);
        list.add(testPojo1);
        list.add(testPojo2);
        list.add(testPojo3);
        return list;
    }

}
