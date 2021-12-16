package com.vlad.multithreading;

import java.util.Scanner;

public class VolatileKeyWord {
    /* volatile(изменчивый) необходим когда переменная делится между несколькими потоками, когда один поток
     * пишет в переменную, а один или более потоков - читает.
     * Позволяет избежать плохой когерентности(совпадение) кешей - несоответствие дынных в кеше ядра с данными в
     * оперативной памяти. Во время работы первое ядро может закешировать переменную, и если второе ядро изменит
     * эту переменную, изменение произойдет в оперативной памяти, а первое ядро не будет знать об этом.
     * volatile гарантирует что переменная не будет кешироваться.
     * В современных процессорах и ОС когерентность кешей работает очень хорошо уже на процессорном
     * уровне, значение из кешей периодически выгружаются в общую память где они сравниваются и
     * обновляются, однако этот механизм не всегда работает, соответственно, нет никаких гарантий. */

    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();

        Thread thread = new Thread(myThread2);
        thread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread2.shutDown();
    }
}

class MyThread2 implements Runnable {
    private volatile boolean running = true;    // не кешировать переменную

    @Override
    public void run() {
        while (running) {
            System.out.println("Infinity loop");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutDown() {
        this.running = false;
    }
}
