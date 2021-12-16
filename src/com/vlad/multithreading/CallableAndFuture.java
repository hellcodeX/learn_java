package com.vlad.multithreading;

import java.util.Random;
import java.util.concurrent.*;


/* Классы Callable и Future позволяют возвращать значения из потоков, а также позволяют
 * возвращать выброшенные в потоке исключения. Они позволяют вернуть значения метода из потока.
 * Возвращать значение методом из Runnable(нашего потока) нельзя.
 * Передать значение из потока можно использовав статическое поле (потому что анонимный класс
 * внутри основного) класса. Однако можно сделать проще используя интерфейс
 * Callable<тип возвращаемого значения>. При использовании лямбда выражения джава сама
 * понимает что, если в теле есть return, следует использовать интерфейс Callable, а не Runnable.
 * К возвращаемому значению из потока можно получить доступ используя интерфейс Future<возвращаемый тип>.
 * Когда поток завершит свое выполнение мы получим наше значение. От сюда и название future - будущее.  */

public class CallableAndFuture {
    private static int result;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Starting");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");
                result = 5;
            }
        });

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(result);
    }

    public static int calculate() {
        return 5 + 2;
    }
}

class CallableAndFuture2 {
    private static int result;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                System.out.println("Starting");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");

                Random random = new Random();
                int randomValue = random.nextInt(10);

                if (randomValue < 5)
                    throw new Exception("Something bad happened");

                return randomValue;
            }
        });

        executorService.shutdown();

        try {
            int result = future.get(); // get() дожидается значения от потока, также сюда дойдет исключение.
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            /* Сюда попадают исключения из Callable. */
            Throwable ex = e.getCause(); // getCause() получает причину исключения
            System.out.println(ex.getMessage());
        }
    }

    public static int calculate() {
        return 5 + 2;
    }
}
