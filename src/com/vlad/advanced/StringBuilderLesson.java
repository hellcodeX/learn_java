package com.vlad.advanced;

public class StringBuilderLesson {
    public static void main(String[] args) {
/*  В Java существуют 2 типа объектов:
    -mutable (поля объекта изменяемы)
    -immutable (поля объекта неизменяемы)
    Тип данных String - immutable. */

        String str = "some words";
        // Все методы строки не оперируют на существующей строке,
        // они возвращают новую строку.
        str.toUpperCase();
        // Строка str не изменилась.
        System.out.println(str);
        System.out.println(str.toUpperCase());

        str = str.toUpperCase();
        // Так как на строку "some words" ничего не ссылается он удалиться GC.

        System.out.println(str);

        String str1 = "one";
        String str2 = "two";
        String str3 = "three";

        // Сперва на основе str1 и str2 создается новая строка "onetwo".
        // После создается новая строка на основе "onetwo" и str3 "onetwothree"
        // Следовательно конкатенация строк является дорогой операцией поскольку
        // для конкатенации 2 строк создается 2 дополнительные строки.
        System.out.println(str1 + str2 + str3);

        System.out.println("-------------------------");

        // StringBuilder создает mutable строку.
        StringBuilder sb = new StringBuilder("StringBuilder line: ");
        System.out.println(sb.toString());
        for (int i = 0; i < 5; i++) {
            sb.append(Integer.toString(i));
        }
        // При этом дополнительные строки не создаются.
        System.out.println(sb.toString());

        // Метод append() возвращает объект класса StringBuilder, на котором он был вызван,
        // поэтому запись можно сократить используя цепочки методов (method chaining).
        sb.append("Hi").append(" method chaining");
        System.out.println(sb.toString());
    }
}
