package com.vlad.multithreading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockNote {
    public static void main(String[] args) throws InterruptedException {
        RunnerClass runner = new RunnerClass();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.firstThread();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.finished();

    }
}

class RunnerClass {
    private Account account1 = new Account();
    private Account account2 = new Account();

    public void firstThread() {
        Random random = new Random();

        synchronized (account1) {
            synchronized (account2) {
                for (int i = 0; i < 10000; i++) {
                    Account.transfer(account1, account2, random.nextInt(100));
                }
            }
        }
    }

    public void secondThread() {
        Random random = new Random();

        synchronized (account1) {
            synchronized (account2) {
                for (int i = 0; i < 10000; i++) {
                    Account.transfer(account2, account1, random.nextInt(100));
                }
            }
        }
    }

    public void finished() {
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

        System.out.println("Total balance " + (account1.getBalance() + account2.getBalance()));
    }
}

/* Дедлоки также могут возникнуть при использовании synchronized.
* Локи должны быть залочены и разлочены в том же порядке, иначе возникнет deadlock -
* потоки будут ждать друг друга вечно. Тем не менее есть метод позволяющий этого избежать.
* Полезно когда порядок разлока не может быть сохранен из-за логики работы программы. */

class DeadLockWithReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        RunnerClassWithReentrantLock runner = new RunnerClassWithReentrantLock();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.firstThread();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.finished();

    }
}


/* ReentrantLock позволяет избежать вложенности synchronized().
 * Метод unlock() всегда нужно вызывать в finally блоке, иначе при ошибке, наши локи всегда
 * будут захвачены. Метод tryLock() возвращает true если смог забрать лок, false если нет. */
class RunnerClassWithReentrantLock {
    private Account account1 = new Account();
    private Account account2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();


    // Теперь проблемы дедлока не возникнет
    public void takeLocks(Lock lock1, Lock lock2) {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;

        while (true) {
            try {
                firstLockTaken = lock1.tryLock();
                secondLockTaken = lock2.tryLock();
            } finally {
                if (firstLockTaken && secondLockTaken) {
                    return;
                }

                if (firstLockTaken) {
                    lock1.unlock();
                }

                if (secondLockTaken) {
                    lock2.unlock();
                }
            }

            /* После каждого неуспешного взятия 2 локов будем ждать 1 мс, чтобы дать
            * время другим потокам отдать эти локи. */
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void firstThread() {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            takeLocks(lock1, lock2);

            try {
                Account.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            takeLocks(lock2, lock1);

            try {
                Account.transfer(account2, account1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

        System.out.println("Total balance " + (account1.getBalance() + account2.getBalance()));
    }
}

class Account {
    private int balance = 10000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account acc1, Account acc2, int amount) {
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }
}