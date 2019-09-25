package ru.study.thread;

public class ThreadLiveCicleExp {
    public static void main(String[] args) throws InterruptedException {
        NewThreadEx newThreadEx = new NewThreadEx();
        newThreadEx.start();
        //newThreadEx.setPriority(Thread.MAX_PRIORITY);//set priority for thread, не гарантированно
        //Thread.yield();//give time to other thread for work, не гарантированно
        //Thread.sleep(3000);//sleep for thread main on 3 sec
        newThreadEx.join();//wait, when thread do all work and then this thread was dead and then work other thread, гарантированно
        System.out.println(Thread.currentThread().getName());
    }
}

class NewThreadEx extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
