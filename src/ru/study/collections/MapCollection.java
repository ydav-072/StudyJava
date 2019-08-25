package ru.study.collections;

import java.util.*;

public class MapCollection {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("1", "one");
        map.put("3", "two");
        map.put("2", "three");

        Map map1 = new Hashtable();
        Map map2 = new TreeMap();
        Map map3 = new LinkedHashMap();
    }
}
