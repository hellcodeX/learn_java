package com.vlad.multithreading;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* Паттерн producer-consumer встречается часто в многопоточном программировании. Часто один или более
* потоков производят что-то, один или более потоков потребляют что-то. Producer задает задачи,
* consumer их выполняет.
* На практике, чаще всего мы будем использовать классы из пакета java.util.concurrent, редко
* прийдется вручную на низком уровне реализовывать синхронизацию потоков с помощью ключевого слова
* synchronized, потому что для большинства задач существует уже готовый класс. Все классы из
* java.util.concurrent потокобезопасны(threadsafe) - по умолчанию синхронизованы и к ним можно без
* опасений обращаться во многих потоках. */

public class PatternProducerConsumerWithConcurrencyClass {
    /* Отличается от обычной очереди тем что:
     *   - она потокобезопасна
     *   - она имеет предельный размер, больше которого не может вырасти
     *   - она ведет себя особым образом если заполняется, или пустая и мы хотим получить
     *       из нее элемент.
     *
     * put() и take() - потокобезопасные версии offer() и pull().  */

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
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

    private static void produce() throws InterruptedException {
        Random random = new Random();

        while (true) {
            queue.put(random.nextInt(100)); // подождать пока место не освободиться если очередь полна
        }
    }

    private static void consumer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            Thread.sleep(100);

            //queue.take(); // ждет если в очереди нет элементов
            if (random.nextInt(10) == 5) {
                /* Иногда за время пока число из очереди отображается в консоли поток producer()
                * успевает добавить новый элемент, поэтому размер равен 10 к моменту отображения размера. */
                System.out.println(queue.take());
                System.out.println("Queue size is " + queue.size());
            }
        }
    }
}
