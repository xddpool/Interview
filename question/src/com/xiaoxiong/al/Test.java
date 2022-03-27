package com.xiaoxiong.al;


import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Character> characters = new LinkedList<>();

        characters.add('m');
        characters.add('M');
        characters.add('b');
        characters.add('c');
        characters.add('c');
        characters.add('b');
        characters.add('c');

        int eliminate = eliminate(characters);
        System.out.println(eliminate);
    }

    public static int eliminate(LinkedList<Character> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            Character a = list.get(i);
            Character b = list.get(i + 1);
            if (a.equals(b)) {
                list.remove(i);
                list.remove(i);
                i--;
            }
        }

        int i = list.size();
        return i;
    }
}

