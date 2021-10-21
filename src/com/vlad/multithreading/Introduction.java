package com.vlad.multithreading;

public class Introduction {
    /* В Java многопоточность представлена в виде виртуальной параллельности.
    * Всегда создается поток main (главный поток). Все что находится в методе main
    * работает последовательно в одном потоке.
    *
    * Многопоточность позволяет выполнять код параллельно с другим кодом. Она может работать
    * даже на одноядерном процессоре, поскольку параллельность является виртуальной, и процессор быстро
    * переключается между задачами (потоками). В многоядерном процессоре java может распределить потоки
    * на разные ядра процессора. Основная цель многопоточного программирования - реализовать какой-то функционал,
    * выполнять задачи параллельно чтобы не заставлять пользователя ждать (сложные задачи выполнялись в
    * фоновом режиме).
    *
    * Потоки в java не синхронизированы (могут выполняться в любом порядке). Поток main может завершить
    * свое выполнение, но созданные потоки продолжат работу пока не закончат ее.
    * Программа считается завершенной, когда все потоки закончат свое исполнение. */

    public static void main(String[] args) throws InterruptedException {
        // 1-й способ создания потоков
        MyThread myThread = new MyThread();
        // Метод start() запускает метод run() который мы переопределили в отдельном потоке.
        myThread.start();

        // для примера несинхронизированности потоков
        MyThread myThread1 = new MyThread();
        myThread1.start();

        // статический метод класса Thread
        System.out.println("I am going to sleep");
        Thread.sleep(1000);
        System.out.println("Hello from main thread");

        // 2-й способ (предпочтительный)
        Thread thread = new Thread(new Runner());
        thread.start();
    }
}

class Runner implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from new thread");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello from myThread" + i);
        }
    }
}
