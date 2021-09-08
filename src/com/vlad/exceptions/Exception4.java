package com.vlad.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class Exception4 {
    public static void main(String[] args) throws IOException {
        // Так как все исключения метода run() наследуются от IOException можно бросать только его.
        run();

        // Для каждого исключения можем обрабатывать по-разному.
        try {
            run3();
            // Так как ParseException не наследуется от IOException нужно его обрабатывать в отдельном блоке.
        } catch (ParseException e) {
            e.printStackTrace();
            // Так как NoSuchMethodException не наследуется от IOException нужно его обрабатывать.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            run2();
            // В Java 7 появился multicatch - позволяет обрабатывать несколько исключений одинаково.
        } catch (ParseException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            run3();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /* Блок catch NoSuchMethodException никогда не будет обработан, так как Exception перехватит
        * первым все исключения. */
          //catch (NoSuchMethodException e) {
          //e.printStackTrace();
          // }
    }

    // Метод может выбрасывать сколько угодно исключений.
    public static void run() throws IOException, FileNotFoundException, IllegalArgumentException {

    }

    public static void run2() throws IOException, ParseException, IllegalArgumentException, NoSuchMethodException {

    }

    public static void run3() throws IOException, ParseException, IllegalArgumentException, NoSuchMethodException {

    }
}
