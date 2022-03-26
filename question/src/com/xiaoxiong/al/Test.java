package com.xiaoxiong.al;


import java.util.Arrays;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {

        String s = "www.baidu.com";

        String[] split = s.split("\\.");

        HashMap<Object, Object> map = new HashMap<>();

        map.entrySet().stream();

        System.out.println(Arrays.toString(split));
    }
}

