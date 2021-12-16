package com.vlad.multithreading;

import java.util.Scanner;

public class WaitAndNotify {
    /* wait() и notify() определены у объекта класса Object. С помощью этих методов можно создать
     * паттерн producer-consumer без использования дополнительных классов. Эти методы есть у всех
     * объектов по той причине, что в джаве можно синхронизироваться на любом объекте.
     * Метод wait() и notify() может вызываться только внутри синхронизованного блока, вне синхронизованного
     * блока не имеют смысла. Эти методы не привязываются к объекту на котором идет синхронизация.
     * Они привязываются к контексту где находятся, то есть к this. Следовательно, любой вызов этих
     * методов к другим объектам синхронизации нужно указывать явно. Пример: myObject.wait().
     *
     * wait(1000) - подождать 1000мс пока не будет вызван notify, и если этого не произошло
     * этот поток продолжит свое выполнение в том случае если монитор будет у этого потока.
     *
     * notifyAll() - разбудить все потоки
     * notify() не освобождает монитор объекта в отличие от wait(). Освобождает монитор выход
     * из блока синхронизации. Только после освобождения монитора выполнение продолжится
     * с места где был вызван wait(). Чаще всего метод notify() должен быть в конце блока синхронизации.
     * notify() - разбудить один поток который ждет(вызвал метод wait() на этом объекте синхронизации)
     *
     * wait() и notify() это низкоуровневый способ координировать действия потоков и обмениваться
     * сообщениями между ними. */

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer wn = new ProducerConsumer();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class WaitAndNotifyUtil {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread started...");
            wait(); // метод wait() вызывается на объекте this. Эквивалентно wait() <=> this.wait()
            /* Метод wait() делает 2 вещи:
                1 - отдает intrinsic lock, который забрали в потоке (внутренний лок на котором
                 шла синхронизация). Следовательно, другие потоки могут забрать лок и продолжить свою работу,
                 если они синхронизированы на том же объекте.
                2 - ждем пока будет вызван notify() */
            System.out.println("Producer thread resumed...");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000); // для того чтобы метод wait() в produce() выполнился первым
        Scanner scanner = new Scanner(System.in);

        synchronized (this) {
            System.out.println("Waiting for return key pressed...");
            scanner.nextLine();
            notify(); // разбудить один поток который ждет(вызвал метод wait() на этом объекте(this))
        }
    }
}
