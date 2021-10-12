package com.vlad.JCF;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LinkedHashMapAndTreeMap {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>(); // порядок не гарантируется
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(); // сохраняется порядок добавления пар
        Map<Integer, String> treeMap = new TreeMap<>(); // сортирует пары по ключу
        // (в случае строк, используется лексикографический порядок). Для ключа должен быть задан критерий сортировки.
        // Строки и числа по умолчанию сортируются в естественном порядке (natural ordering).

        /* Лексикографический порядок:
        a < b < c (0 < 1 < 2)
        aa < ab (00 < 01)
        */

        System.out.println("HashMap:");
        testMap(hashMap);
        System.out.println();

        System.out.println("LinkedHashMap:");
        testMap(linkedHashMap);
        System.out.println();

        System.out.println("TreeMap:");
        testMap(treeMap);
        System.out.println();
    }

    public static void testMap(Map<Integer, String> map) {
        map.put(39, "Bob");
        map.put(12, "Mike");
        map.put(78, "Tom");
        map.put(0, "Tim");
        map.put(1500, "Lewis");
        map.put(7, "Bob");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
