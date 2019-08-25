package ru.study.collections;

import java.util.*;

public class AllCollection {
    public static void main(String[] args) {
        Collection collection;//main interface

        List collectionList = new ArrayList();
        collectionList.add("0");
        collectionList.add("1");
        collectionList.add("2");
        collectionList.add("3");
        collectionList.add(4,"4");
        collectionList.remove(4);
        collectionList.remove("3");
        System.out.println(collectionList.get(0));
        for (int i = 0; i < collectionList.size(); i++){
            System.out.println("List: " + collectionList.get(i));
        }

        Set collectionSet = new HashSet();
        collectionSet.add("0");
        collectionSet.add("0");
        collectionSet.add("1");
        collectionSet.add("2");
        collectionSet.add("2");
        collectionSet.add("3");
        collectionSet.add("4");
        collectionSet.add("4");
        collectionSet.remove("3");
        for (Object o : collectionSet){
            System.out.println("Set: " + o);
        }

        Queue collectionQueue = new PriorityQueue();
        collectionQueue.offer("1");
        collectionQueue.offer("2");
        collectionQueue.offer("3");
        collectionQueue.offer("4");
        collectionQueue.offer("5");
        collectionQueue.offer("6");

        Iterator iterator = collectionQueue.iterator();
        while (iterator.hasNext()){
            System.out.println("Queue: " + iterator.next());
        }

        Map map = new HashMap();
        map.put("0", "first_elem");
        map.put("1", "second_elem");
        map.put("2", "third_elem");
        map.put("3", "fourth_elem");
        map.put("4", "fives_elem");
        map.put("5", "six_elem");
        System.out.println("map i: " + map.get("0"));
        Set set = map.entrySet();
        Set set1 = map.keySet();
        for (Object o : set){
            System.out.println("entryMap: " + o);
        }
        for (Object o : set1){
            System.out.println("keyMap: " + o);
        }
    }
}
