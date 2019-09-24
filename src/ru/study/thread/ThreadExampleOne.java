package ru.study.thread;

import java.util.concurrent.Callable;

// we can do new tread with 3 ways:
public class ThreadExampleOne {
    public static void main(String[] args) {
        SomeObject someObject = new SomeObject();
        someObject.start();//тут мы создаём поток, только через вызов метода start(). весь код, который должен работать в этом потоке помещается в метод run()
        System.out.println(Thread.currentThread().getName());//get name of thread

        MyRunnableThread myRunnableThread = new MyRunnableThread();//при имплементации интерфейса необходимо создавать потоки данным способом
        Thread thread = new Thread(myRunnableThread);
        thread.start();
    }
}
//number one
class SomeObject extends Thread{
    private int varInt;
    private String varStr;

    public int getVarInt() {
        return varInt;
    }

    public void setVarInt(int varInt) {
        this.varInt = varInt;
    }

    public String getVarStr() {
        return varStr;
    }

    public void setVarStr(String varStr) {
        this.varStr = varStr;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());//get name of thread
        System.out.println("This is new thread");
    }
}
//number two
class MyRunnableThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("this is second create thread");
    }
}
//number three
class MyClonableThread implements Callable {

    @Override
    public Object call() throws Exception {
        return null;
    }
}
