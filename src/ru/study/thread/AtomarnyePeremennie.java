package ru.study.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomarnyePeremennie {
    static AtomicInteger atomicInteger = new AtomicInteger(0);//специальная обёртка, которая позволяет
    // гарантированно выполнять операции атомарно
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++){
            new MyThreadAtomic().start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicInteger);
    }
    static class MyThreadAtomic extends Thread{
        @Override
        public void run() {
            atomicInteger.incrementAndGet(); //метод для атомарной инкрементации
        }
    }
}
