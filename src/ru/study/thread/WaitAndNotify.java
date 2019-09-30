package ru.study.thread;
//метод wait говорит потоку что необходимо ожидать(спать) пока его не модифицируют с помощью notify
//это позволяет избегать постоянного опроса на освобождение ресурсов или чего-либо...
public class WaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        ThreadB threadB = new ThreadB();
        threadB.start();
        synchronized (threadB){
            threadB.wait();
            // главный - main поток, когда Я пишу new Thread().start() я после вызова start создаю еще одинк поток,
            // в результате в программе 2-а поток, главный и созданый.  В этом программе я создаю новый поток, запускаю его и вызываю метод wait
            // из главного потока и жду, когда созданый поток занотифает меня, что он закончил работу и я могу продолжить выполнение,
            // соответсвенно когда threadB все посчитает, он отправляет notify ожидающему его потоку и тот когда получает notify
            // прекращает ждать и продложает свое выполнение.
        }
    }
    static class ThreadB extends Thread{
        int total;
        @Override
        public void run() {
            synchronized (this) { //синхронизируемся по обьекту
                for (int i = 0; i < 5; i++) {
                    total += i;
                    try {
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notify();//сообщение что работа закончена
            }
        }
    }
}
