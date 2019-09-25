package ru.study.thread;

public class ThreadSynhronizeExp {
    public static void main(String[] args) throws InterruptedException {
        Resources resources = new Resources();
        resources.i = 5;
        NewThreadExpl newThreadEx = new NewThreadExpl();
        newThreadEx.setName("one");
        NewThreadExpl newThreadEx1 = new NewThreadExpl();

        newThreadEx.setResources(resources);
        newThreadEx1.setResources(resources);
        newThreadEx.start();
        newThreadEx1.start();
        newThreadEx.join();
        newThreadEx1.join();
        System.out.println(resources.i);
    }
}
class NewThreadExpl extends Thread{
    Resources resources;

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    @Override
    public void run() {
        resources.changeI();
    }
}

class Resources{
     int i;

    public synchronized void changeI(){
        int i = this.i;
        if (Thread.currentThread().getName().equals("one")){
            Thread.yield();
        }
        i++;
        this.i = i;
    }
}
