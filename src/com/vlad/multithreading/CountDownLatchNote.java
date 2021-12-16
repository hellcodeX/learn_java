package com.vlad.multithreading;

/* Count down latch - в переводе на рус. защелка обратного отсчета. При создании объекта этого класса
* следует указать количество итераций, которые мы должны отсчитать назад прежде чем защелка нам
* отопрется.
* await() - ждать пока счетчик не будет равен 0
* Пример создания счетчика с защелкой:
* CountDownLatch countDownLatch = new CountDownLatch(начальное значение счетчика);
* Думать о синхронизации потоков не нужно, так как этот класс лежит в пакете concurrent - значит потокобезопасный
*  */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchNote {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor(countDownLatch));
        }

        executorService.shutdown();

        countDownLatch.await();
        System.out.println("Latch has been opened, main thread is proceeding!");
    }
}

class Processor implements Runnable {
    private CountDownLatch countDownLatch;

    public Processor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countDownLatch.countDown(); // отсчитать назад (декрементировать на 1)
    }
}

class CountDownLatchExample2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor2(i, countDownLatch));
        }

        executorService.shutdown();

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            countDownLatch.countDown();
        }
    }
}

class Processor2 implements Runnable {
    private int id;
    private CountDownLatch countDownLatch;

    public Processor2(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread with id " + id + " proceeded");
    }
}
