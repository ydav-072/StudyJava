package ru.study.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
// аналог wait and notify
public class ConditionExample {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static int account =  0;
    public static void main(String[] args) {
        new OperationMinus().start();
        new OperationPlus().start();
    }

    static class OperationPlus extends Thread{
        @Override
        public void run() {
            lock.lock();
            account += 10;
            condition.signal();//сигнал, что метод произвел работу
            lock.unlock();
            System.out.println("account after plus: " + account);
        }
    }
    static class OperationMinus extends Thread{
        @Override
        public void run() {
            if (account < 10){
                try {
                    lock.lock();
                    System.out.println("account before minus: " + account);
                    condition.await();//ожидать пока не выполнится условие и другие потоки не пополнят аакаунт
                    System.out.println("account after await() in minus: " + account);
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            account -= 10;
            System.out.println("account in the end:" + account);
        }
    }
}
