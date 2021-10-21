package com.vlad.multithreading;

import java.util.Scanner;

public class VolatileKeyWord {
    /* volatile необходим когда переменная делится между несколькими потоками, когда один поток
     * пишет в переменную, а один или более потоков - читает. */

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
    private boolean running = true;

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
