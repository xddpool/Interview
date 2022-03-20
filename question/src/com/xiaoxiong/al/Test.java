package com.xiaoxiong.al;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> listHashMap = new HashMap<>();
        List<Integer> list = Arrays.asList(1, 2);
        List<Integer> list1 = Arrays.asList(3, 4);
        List<Integer> list2 = Arrays.asList(5, 6, 8);
        List<Integer> list3 = Arrays.asList(7, 8);
        List<Integer> list4 = Arrays.asList(9, 10, 11);
        listHashMap.put(0, list);
        listHashMap.put(1, list1);
        listHashMap.put(2, list2);
        listHashMap.put(3, list3);
        listHashMap.put(4, list4);

        StringBuilder builder = new StringBuilder();

        Stream<Map.Entry<Integer, List<Integer>>> stream = listHashMap.entrySet().stream();
        stream.filter(integerListEntry -> integerListEntry.getValue().size() > 2)
                .map(integerListEntry -> integerListEntry.getKey())
                .forEach(x -> builder.append(x).append(";"));
        System.out.println(builder.substring(0, builder.length() - 1));
    }
}

