package ru.study.thread;

import java.util.ArrayList;
import java.util.List;

//не стоит слепо пологаться на синхронизированные коллекции, лучше делать что-то типо того
public class SynchronizedCollection {
    public static void main(String[] args) {
        NameList nameList = new NameList();
        nameList.add("Alex");
        class MyNewThread extends Thread{
            @Override
            public void run() {
                System.out.println(nameList.removeFirst());
            }
        }
        MyNewThread myNewThread = new MyNewThread();
        myNewThread.setName("one");
        myNewThread.start();
        new MyNewThread().start();
    }

    static class NameList{
       private List nameList = new ArrayList<>();

       public synchronized void add(String name){
           nameList.add(name);
       }

       public synchronized String removeFirst(){
           if (nameList.size() > 0){
               if (Thread.currentThread().getName().equals("one")){
                   Thread.yield();
               }
               return (String)nameList.remove(0);
           }
           return null;
       }
    }
}
