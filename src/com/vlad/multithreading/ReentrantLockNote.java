package com.vlad.multithreading;

/* Класс ReentrantLock нужен, для того чтобы синхронизировать потоки. Он позволяет делать то же самое
* что и ключевое слово synchronized, но с некоторыми отличиями: например позволяет избежать deadlock.
* Если поток n раз залочил метод, иму надо n раз разлочить его, чтобы другой поток мог получить
* к нему доступ
*
*  ReentrantLock позволяет избежать вложенности synchronized().
 * Метод unlock() всегда нужно вызывать в finally блоке, иначе при ошибке, наши локи всегда
 * будут захвачены */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockNote {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.firstThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        task.showCounter();
    }
}

class Task {
    private int counter;
    private Lock lock = new ReentrantLock();

    private void increment() {
        for (int i = 0; i < 10000; i++) {
            counter++;
        }
    }

    public void firstThread() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void secondThread() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void showCounter() {
        System.out.println(counter);
    }
}
