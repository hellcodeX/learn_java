package com.vlad.JCF;

import java.util.HashMap;
import java.util.Map;

public class Note_HashMap {
    /* Map c с англ. - отображение, карта.
    * Отображение - два множества, элементы одного множества сопоставляем элементы другого множества.
    * В Python такая структура данных - словарь.
    * Класс HashMap не гарантирует сохранения порядка, из-за использования хеширования которое зависит
    * от случайных величин.
    * Если порядок пар важен (хотим извлекать в том же порядки в котором помещали), или нужно
    * отсортировать пары по ключу - следует использовать другие классы реализующие Map интерфейс
    * (LinkedHashMap, TreeMap). */

    public static void main(String[] args) {
        // Ключ типа Integer, значение типа String. Отображение числа в строку.
        Map<Integer, String> map = new HashMap<>();
        // Если забыть про <> в new HashMap() в структуре данных будут храниться объекты класса object.

        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(3, "опять три");  // значение по ключу просто перезапишется.

        System.out.println(map);

        System.out.println(map.get(1));
        System.out.println(map.get(5));
        // Если ключа не существует вернуться null.

        // Каждая пара ключ-значение - entry.
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
