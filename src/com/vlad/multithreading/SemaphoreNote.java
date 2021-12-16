package com.vlad.multithreading;

/* Класс семафор используется, когда много потоков хотят получить доступ к 1 ресурсу и используем когда
* хотим ограничить доступ к этому ресурсу (сетевое соединение например). В аргументе конструктора
* передает количество разрешений для потоков.
* release() - отдает разрешение, вызываем когда в потоке заканчиваем использовать ресурс.
* acquire() - вызываем в потоке когда начинаем взаимодействие с ресурсом. Будет ждать если количество
* разрешений равно 0.
* availablePermits() - получаем количество доступных разрешений. */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreNote {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(200);

        Connection connection = Connection.getConnection();
        for (int i = 0; i < 200; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.doWorkWithSemaphore();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

class Connection {
    private static Connection connection = new Connection();
    private int connectionsCount;
    private Semaphore semaphore = new Semaphore(10);

    // Запрещаем создавать объект этого класса модификатором private (паттерн Singleton).
    // Один объект класса Connection в программе.
    private Connection() {
    }

    public static Connection getConnection() {
        return connection;
    }

    public void doWorkWithSemaphore() throws InterruptedException {
        /* Метод release() всегда должен вызываться в finally блоке, иначе программа остановится в этом
         месте, и разрешение никогда не будет возвращено. */

        semaphore.acquire();
        try {
            doWork();
        } finally {
            semaphore.release();
        }
    }

    private void doWork() throws InterruptedException {
        synchronized (this) {
            connectionsCount++;
            System.out.println(connectionsCount);
        }

        // some good work simulation
        Thread.sleep(5000);

        synchronized (this) {
            connectionsCount--;
        }
    }
}
