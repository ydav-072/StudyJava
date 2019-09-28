package ru.study.thread;
//ключевае слово указывает потокам, чтобы они читали и писали информацию из одного и того же места, не кэшируя а непосредственно в память!
public class VolatileExample {
    static volatile int i;
    static volatile int j = 0;
    public static void main(String[] args) {
        new ThreadForRead().start();
        new ThreadForWrite().start();
    }
    static class ThreadForWrite extends Thread{
        @Override
        public void run() {
            while (j < 5){
                System.out.println("increment j: " + (++j));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class ThreadForRead extends Thread{
        @Override
        public void run() {
            int localVar = j;
            while (localVar < 5) {
                if (localVar != j){
                    System.out.println("new value of j is:" + j);
                    localVar = j;
                }
            }
        }
    }
}
