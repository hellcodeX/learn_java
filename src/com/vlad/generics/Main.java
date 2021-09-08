package com.vlad.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /* Дженерики появились Java 5. */
    public static void main(String[] args) {
        // До Java 5
        List animals = new ArrayList();
        animals.add("cat");
        animals.add("dog");
        animals.add(6);

        String animal = (String) animals.get(1);
        System.out.println(animal);
        // Интересное преимущество - разные типы данных в одной коллекции.
        System.out.println((int) animals.get(2));
        System.out.println((Integer) animals.get(2));

        // После Java 5 с параметризацией класса
        List<String> newList1 = new ArrayList<String>();
        List<String> newList2 = new ArrayList<>(); // с Java 7 тип создаваемого объекта можно не указывать.
        newList2.add("cat");
        newList2.add("dog");
        System.out.println(newList2.get(0));
    }
}
