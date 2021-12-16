package com.vlad.multithreading;

/* Синхронизация потоков используется, когда 2 или более потоков пишут в одну переменную.
* Состояние гонки (race condition) - 2 и более потоков одновременно пишут в одну переменную и
* часть инструкций теряется.
* Ключевое слово synchronized решает проблему состояния гонки. Оно применимо только в сигнатуре
* метода и гарантирует что в один момент времени только 1 поток может получить доступ к телу метода.
*
* Устройство synchronized:
* В джаве каждому объекту присваивается специальная сущность монитор (Intrinsic Lock или Monitor Lock).
* Каждому созданному объекту в джаве присваивается монитор. Монитор в один момент времени может быть
* только у одного потока. Эта сущность используется, для того чтобы дать понять джаве что в данный
* момент времени этот поток взаимодействует с объектом и другие потоки должны ждать. Монитор нужен
* для того чтобы поток мог получить доступ к полям и методам объекта. При создании объекта джава
* за кулисами создает монитор и привязывает его к этому объекту. Следовательно, для синхронизации
* нужен объект, так как синхронизация производится на объекте.
*
* По умолчанию, без указания объята для синхронизации, синхронизация производится на объекте this. */

public class SynchronizedKeyWord {
    private int counter;

    public static void main(String[] args) {
        SynchronizedKeyWord test = new SynchronizedKeyWord();
        test.doWork();
    }

    public void doWork() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter++;
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter++;
                }
            }
        });

        thread1.start();
        thread2.start();

        System.out.println(counter);    // ошибка 1: мы сразу же выводим значение counter не дожидаясь
                                        // пока эти два потока отработают.
    }
}

class SynchronizedKeyWordCorrect {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        SynchronizedKeyWordCorrect test = new SynchronizedKeyWordCorrect();
        test.doWork();
    }

    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter++;
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter++;
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join(); // заставляет поток main подождать пока поток на выполнится
        thread2.join();

        System.out.println(counter);    // вывод уже после того как потоки отработают

        /* Тем ни менее переменная counter никогда не будет равна 20000 из-за возникновения
        * состояния гонки. Происходит это по причине того, что во время инкремента также происходит
        * чтение переменной.
        * counter++ <=> counter = counter + 1
        * counter++ - не атомарная операция(выполняется за один такт времени) так как состоит
        * из 3 мелких операций - считывание старой переменной, увеличение переменной на единицу,
        * помещение нового значения в переменную counter.
        * Иллюстрация проблемы:
        *     чтение -> увеличение -> запись
        *   поток 1: ч100 -> у101 -> з101 -> ч101 -> у102 -> з102
        *       2 потока считали переменную в одно и то же время, но первый быстрее инкрементировал
        *       переменную.
        *   поток 2: ч100 -> у101 -> з101
        *   Второй поток успел гораздо меньше. В итоге инкремент потерялся.
        *  */
    }
}

class SynchronizedKeyWordCorrectFinal {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        SynchronizedKeyWordCorrectFinal test = new SynchronizedKeyWordCorrectFinal();
        test.doWork();
    }

    private synchronized void increment() {
        counter++;
    }

    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join(); // заставляет поток main подождать пока поток на выполнится
        thread2.join();

        System.out.println(counter);    // вывод уже после того как потоки отработают
        // Проблема состояния гонки решена синхронизированным методом increment()
        // Все отлично!
    }
}

