package ru.study.collections;

import java.util.*;

public class QueueCollection {
    public static void main(String[] args) {
        Queue queue = new PriorityQueue();
        queue.offer(6);
        queue.offer(5);
        queue.offer(1);
        queue.offer(4);
        queue.offer(2);
        queue.offer(3);
        while (queue.size() > 0){
            System.out.println("Sorted queue: " + queue.poll());
        }
        Queue queue1 = new LinkedList();
        queue1.add(6);
        queue1.add(2);
        queue1.add(5);
        queue1.add(4);
        queue1.add(3);
        queue1.add(1);
        //Sort linkedList Queue
       // List list =(List) queue1;
       // Collections.sort(list);
        //end sort
      //  for (int i = 0; i < list.size(); i++){
      //      System.out.println("Sort LinkedList Queue:" + list.get(i));
     //   }
        while (queue1.size() > 0){
            System.out.println(queue1.poll());
        }
        System.out.println("Size after pool: " + queue1.size());

    }
}
