package ru.study.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaitAndNotifyExample {
    static List<String> stringList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        new Operator().start();
        new Machine().start();
    }

    static class Operator extends Thread{//оператор пишет текст, затем машина его печатает, а когда он пишет машина может выполнять предыдущее задание или ждать
        @Override
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                synchronized (stringList){
                    try {
                        stringList.add(bufferedReader.readLine());
                        stringList.notify();//как только ввели и добавили нове значение сообщаем потоку машина что можно печатать, но не гарантирует
                        // что будет выполняться другой поток, по этому необходимо вызвать sleep
                        // а метод wait точно ждёт выполнения другого потока и ыsleep  там не нужен
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(500);// необходимо чтобы не перескакивало сразу из вэйт в оператора
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Machine extends Thread{//машина печатает, а оператор может в это время писать новый текст
        @Override
        public void run() {
            while (stringList.isEmpty()){
                synchronized (stringList){
                    try {
                        stringList.wait();//ждём пока что-то появится
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Machine is type: " + stringList.remove(0));//как только что-то пришло выводим первый элемент и очищаем
                }
            }
        }
    }
}
