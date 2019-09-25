package ru.study.thread;

public class StaticSynchronizedThread {
    public static void main(String[] args) throws InterruptedException {
        Resource.i = 5;
        NewThreadExple newThreadEx = new NewThreadExple();
        NewThreadExple newThreadEx1 = new NewThreadExple();

        newThreadEx.start();
        newThreadEx1.start();
        newThreadEx.join();
        newThreadEx1.join();
        System.out.println(Resource.i);
    }
}

class NewThreadExple extends Thread {
    Resource resources;

    public void setResources(Resource resources) {
        this.resources = resources;
    }

    @Override
    public void run() {
        Resource.changeStaticI();
    }
}

class Resource {
    static int i;

    public synchronized static void changeStaticI() {
        int i = Resource.i;
        if (Thread.currentThread().getName().equals("one")) {
            Thread.yield();
        }
        i++;
        Resource.i = i;
    }
}