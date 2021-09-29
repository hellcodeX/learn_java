package com.vlad.JCF;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Note_LinkedList {
    private static final int SIZE = 100000;

    public static void main(String[] args) {

        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();

        /* Если производиться много считований, следует использовать ArrayList. Разница времени выполнения
        * огромна, в пользу листа массивов (в тысячи раз быстрее если производить доступ к каждому
        * элементу по индексу, в листе размеров 100к). В случае удаления LinkList очень быстр. */

        System.out.println("Получение всех элементов по индексу");
        measureTime1(linkedList, SIZE);
        measureTime1(arrayList, SIZE);

        System.out.println("Добавление в начало");
        measureTime2(linkedList, SIZE);
        measureTime2(arrayList, SIZE);
    }

    private static void measureTime1(List<Integer> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void measureTime2(List<Integer> list, int size) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            // запись в начало листа в array list очень медленна, так как перетаскивает все элементы направо.
            list.add(0, i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
