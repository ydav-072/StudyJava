package ru.study.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableExampleOne {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> integerCallable = new MyCallable();
        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(integerCallable);
        new Thread(integerFutureTask).start();
        System.out.println(integerFutureTask.get());
    }

    static class MyCallable implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            int j = 0;
            for (int i = 0; i < 10; i++, j++) {
                Thread.sleep(300);
            }
            return j;
        }
    }
}
