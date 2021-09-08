package com.vlad.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exception1 {
    /* Исключение - обычный объект класса который наследуется от класса Exception.
     * 2 способа обработать исключение:
     * 1. throws к методу передаст исключение вверх, тем самым обязуя код, который вызвал этот метод
     * обработать исключение, или же просто передать его опять вверх. Обработка исключения делегируется
     * вверх по иерархии вызова методов.
     * 2. обработка с try catch */

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("saf");

        Scanner scanner = new Scanner(file);
    }
}

class Main2 {
    public static void main(String[] args) {
        File file = new File("saf");

        try {
            Scanner scanner = new Scanner(file);
            // А вот тут код дальше не выполниться, произойдет сразу переход в блок catch.
            System.out.println("lalalala");
        } catch (FileNotFoundException e) {
            /* Здесь мы можем не выбрасывать "красный текст" и сами обработать исключение. */
            //e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Уупсс! файл не найден");
        }
        // При условии, что мы обработали исключение, дальше код корректно выполняется.
        System.out.println("После блока try catch");
    }
}
