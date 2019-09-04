package ru.study.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetCollection {
    public static void main(String[] args) {
        Set set = new HashSet();
        Set set1 = new TreeSet();
        Set set2 = new LinkedHashSet();
        set.add("1");
        set.add("2");
        set.add("2");
        set.add("4");
        set.add("4");
        set.add("5");
        for (Object o : set){
            System.out.println(o);
        }

    }
}
