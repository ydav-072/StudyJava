package ru.study.thread;

public class DeadLockExample {
    public static void main(String[] args) {
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();
        resourceA.resourceB = resourceB;
        resourceB.resourceA = resourceA;

        MyThreadDeadLock1 myThreadDeadLock1 = new MyThreadDeadLock1();
        MyThreadDeadLock2 myThreadDeadLock2 = new MyThreadDeadLock2();
        myThreadDeadLock1.resourceA = resourceA;
        myThreadDeadLock2.resourceB = resourceB;
        myThreadDeadLock1.start();
        myThreadDeadLock2.start();
    }
}

class MyThreadDeadLock1 extends Thread{
    ResourceA resourceA;
    @Override
    public void run() {
        System.out.println(resourceA.getI());
    }
}

class MyThreadDeadLock2 extends Thread{
    ResourceB resourceB;
    @Override
    public void run() {
        System.out.println(resourceB.getI());
    }
}

class ResourceA{
    ResourceB resourceB;
    public synchronized int getI(){
        return resourceB.returnI();
    }
    public synchronized int returnI(){
        return 1;
    }
}
class ResourceB{
    ResourceA resourceA;
    public synchronized int getI(){
        return resourceA.returnI();
    }
    public synchronized int returnI(){
        return 2;
    }
}
