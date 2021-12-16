package com.vlad.multithreading;

/* Ключевое слово synchronized неявно синхронизирует на this.
 * Synchronized Block - позволяет явно задать объект для синхронизации.
 * public void increment() {
 *   код для несинхронного выполнения
 *   synchronized (this) {
 *       код для синхронного выполнения
 *       counter++;
 *   }
 *   код для несинхронного выполнения
 * }
 * эквивалентно
 * public synchronized void increment() {
 *   counter++;
 * }
 *  */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Synchronized2 {

    public static void main(String[] args) {
        new Worker().main();
    }
}

class Worker {
    Random random = new Random();

    // При создании объектов для синхронизации принято использовать класс Object, хотя технически
    // можно использовать любой класс.
    Object lock1 = new Object();
    Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    /* На примере листов состояние гонки работает так же как на примере с числами.
     * Некоторые инсерты потеряются.
     * Если один поток вырывается вперед, то второй поток ждет.
     * В итоге в случае синхронизации на одном объекте время выполнения будет в 2 раза больше
     * и от второго потока не будет ускорения работы. Если поток достигнет метода synchronized
     * он заберет себе монитор, поэтому другой поток не сможет параллельно выполнять второй метод
     * addToList2().
     * Пересечение данных в потоках - изменение одних и тех же данных в разных потоках одновременно.
     * В случае когда между потоками не происходит пересечения данных можно сделать так, чтобы
     * один поток выполнял один метод, а второй поток - другой метод параллельно, так как в этом случае
     * это безопасно, и поэтому следует синхронизироваться на разных объектах.
     * Иначе говоря, мы хотим сделать так, чтобы оба метода могли выполняться одновременно в разных
     * потоках, но не хотим чтобы ОДИН И ТОТЖЕ метод выполнялся в разных потоках одновременно,
     * во избежания состояния гонки. То есть мы хотим чтобы потоки одновременно записывали в разные листы. */

    public synchronized void addToList1() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list1.add(random.nextInt(99));
        }
    }

    public void addToList2() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list2.add(random.nextInt(99));
        }
    }

    public void work() {
        for (int i = 0; i < 1000; i++) {
            addToList1();
            addToList2();
        }
    }

    public void main() {
        long before = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long after = System.currentTimeMillis();
        System.out.println("Program took " + (after - before) + " ms to run");

        System.out.println("List1: " + list1.size());
        System.out.println("List2: " + list2.size());
    }
}
