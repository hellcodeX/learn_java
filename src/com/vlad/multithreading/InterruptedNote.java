package com.vlad.multithreading;

import java.util.Random;

/* Механизм прерываний позволяет из одного потока, прервать выполнение другого потока.
 * Для прерываний используется метод interrupt() класса Thread. Прерывание не убивает поток.
 * Есть устаревший и плохой метод stop() убивающий поток. Плохой поскольку мгновенно завершает
 * роботу потока, который мог все еще выполнять свою работу, что приведет не определенному поведению.
 * interrupt() не убивает поток, он продолжит свое выполнение, но даем потоку сообщение, что
 * хотим его остановить. Благодаря этому мы можем грамотно завершить поток, не вызывая неопределенного
 * состояния. Исключение InterruptedException возникает когда некоторые методы выполняются
 * в потоке который был прерван. */

public class InterruptedNote {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1_000_000_000; i++) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("Thread was interrupted");
                        break;
                    }

//                    if(Thread.currentThread().isInterrupted()) {
//                        System.out.println("Thread was interrupted");
//                        break;
//                    }

                    Math.sin(random.nextInt());
                }
            }
        });

        System.out.println("Starting thread");

        thread.start();

        Thread.sleep(1000);
        thread.interrupt();

        thread.join();

        System.out.println("Thread has finished");
    }
}
