package com.vlad.multithreading;

/* Пул потоков - множество потоков.
* ExecutorService(сервис по выполнению) - это и есть пул потоков. */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolNote {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            /* Метод submit() добавляет задачу сервису по выполнению. В нем 2 потока для выполнения
            * заданий. Если оба потока заняты, то задания ждут в очереди на выполнение.
            * Класс представляющий задание должен реализовывать интерфейс Runnable. */
            executorService.submit(new Work(i));
        }

        /* Метод shutdown() говорит сервису по выполнению, что мы перестаем добавлять задания,
         * и беремся за выполнение заданий которые были переданы. Этот метод возвращается мгновенно
         * так же как и start() при запуске потоков, вызвали и в потоке main продолжаем выполнение. */
        executorService.shutdown();
        System.out.println("All tasks submitted"); // ок все таски были переданы

        executorService.awaitTermination(1, TimeUnit.DAYS);  /* Сколько времени мы готовы ждать
        до того как потоки выполнят наши задания. Если не выполняться идем дальше. Подобен джоину. */
    }
}


class Work implements Runnable {
    private int id;

    Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Work " + id + " was complete");
    }
}