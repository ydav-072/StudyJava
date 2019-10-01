package ru.study.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockExample {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }
    static class Thread1 extends Thread{
        @Override
        public void run() {
            lock.lock();
            System.out.println(getName() + " start working");
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " stop working");
            lock.unlock();
            System.out.println(getName() + " lock is released");
        }
    }
    static class Thread2 extends Thread{
        @Override
        public void run() {
            System.out.println(getName() + " begin working");
            while (true){
                if (lock.tryLock()){ // пробуем получить лок
                    System.out.println(getName() + " is working");
                    System.out.println(getName() + " is stop working");
                    break;
                } else{// пока лок не получим ждём
                    System.out.println(getName() + " waiting");
                }
            }
        }
    }
}
