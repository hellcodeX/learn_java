package com.vlad.JCF;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Note_Queue {
    /* Элемент помещенный раньше других будет доставаться из этой структуры данных первым
     (FIFO - First In First Out).
     ArrayBlockingQueue часто используется в многопоточности когда множество потоков обращаются
     к одному ресурсу. В нем мы обязаны задать максимальный размер очереди. */

    /* Методы add(), remove(), element() в случае ошибки выбрасывают исключение,
     * методы offer(), poll(), peak() в случае ошибки возвращают значение. */

    public static void main(String[] args) {
        Queue<PersonF> queue = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            PersonF personF = new PersonF(i);
            queue.add(personF);
        }

        System.out.println(queue);

        for (int i = 0; i < 5; i++) {
            queue.poll();
            System.out.println(queue);
        }

        // мы обязаны задать максимальный размер очереди
        Queue<PersonF> blockingQueue = new ArrayBlockingQueue<>(10);

        for (int i = 0; i < 5; i++) {
            PersonF personF = new PersonF(i);
            blockingQueue.add(personF);
        }

        System.out.println(blockingQueue);

        for (int i = 0; i < 5; i++) {
            blockingQueue.poll();
            System.out.println(blockingQueue);
        }

        System.out.println("============================================");

        Queue<PersonF> queue1 = new LinkedList<>();
        queue1.add(new PersonF(5));
        queue1.add(new PersonF(2));
        queue1.add(new PersonF(3));

        System.out.println(queue1);

        System.out.println("remove()");
        // удаление из очереди
        queue1.remove();
        System.out.println(queue1);

        System.out.println("peek()");
        // посмотреть на первый элемент и оставить его в очереди peek() == element()
        System.out.println(queue1.peek());
        System.out.println(queue1);

        System.out.println("offer()");
        // посмотреть на первый элемент и оставить его в очереди offer() == add()
        System.out.println(queue1.peek());
        System.out.println(queue1);

        System.out.println("poll()");
        // посмотреть на первый элемент и оставить его в очереди poll() == remove()
        System.out.println(queue1.peek());
        System.out.println(queue1);
    }
}

class PersonF {
    private int id;

    public PersonF(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}
