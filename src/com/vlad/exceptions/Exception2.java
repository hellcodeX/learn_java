package com.vlad.exceptions;

import java.io.IOException;
import java.util.Scanner;

public class Exception2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int x = Integer.parseInt(scanner.nextLine());

            if (x != 0) {
                /* Если в ходе выполнения метода может произойти выброс исключения,
                 * то мы должны в сигнатуру метода добавить throws, либо обработать
                 * исключение с try catch. */
                throw new IOException(); // выброс исключения
            }
        }
    }
}

class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int x = Integer.parseInt(scanner.nextLine());

            if (x != 0) {
                try {
                    // можно сразу обработать исключение
                    throw new IOException(); // выброс исключения
                } catch (IOException e) {
                    // обработка исключения
                    System.out.println("Пользовать ввел не ноль");
                }
            }
        }
    }
}

// создание собственного исключения
class ScannerException extends Exception {
    public ScannerException(String description) {
        super(description);
    }
}

class Main4 {
    public static void main(String[] args) throws ScannerException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int x = Integer.parseInt(scanner.nextLine());

            if (x != 0) {
                throw new ScannerException("Пользователь не 0"); // выброс исключения
            }
        }
    }
}
