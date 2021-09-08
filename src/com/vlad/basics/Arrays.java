package com.vlad.basics;

public class Arrays {
    public static void main(String[] args) {
        int num = 10; // примитивный тип данных
        char character = 'a'; // примитивный тип данных

        String str = "word";
        String string = new String("word");
        /* Оба способа создания строк равноценны.
         Строки являются ссылочными типами данных. */

        int[] numbers = new int[5]; // ссылочный тип данных
        System.out.println(java.util.Arrays.toString(numbers));
        int[] massive = {1, 2, 3}; // создание и инициализация
        // По умолчанию инициализируется числом 0
        Display(numbers);
        Display(massive);
    }

    public static void Display(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("element[" + i + "]: " + numbers[i]);
        }
    }
}
