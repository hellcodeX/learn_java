package com.vlad.JCF;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Note_HashCodeEquals {
    public static void main(String[] args) {
        /* Java определяет уникальность объекта с помощью контракта
        *  hashCode-equals. Их используют коллекции для определения уникальности объекта.
        * Метод equals() медленный, поэтому вызывается только в случае коллизии(2 объекта имеют одинаковый хеш),
        * в остальных случаях вызывается быстрый метод hashCode(), который реализован нативно (на с++).
        * Хеш функция сопоставляет объекту целое число, то-есть преобразует объект произвольной длины
        * (количество и размер полей), в целое число фиксированной длины.
        *
        * 1. Вызывается метод hashCode. Если хеш коды разные, то объекты гарантировано разные, так как хеш функция
        * детерминирована, и для одного и того же объекта она всегда будет возвращать одно и то же число.
        * 2. Если хеш коды равны, то вызывается метод equals(), чтобы убедиться в отсутствии коллизии.
        *
        * Java в своей реализации hashSet использует hashMap, тем что hashMap обеспечивает уникальные ключи.
        * Значение в hashSet это ключи в hashMap.
        * HashMap в своей реализации использует массив связанных списков.
        * В любом объекте который мы хотим использовать в качестве ключа должен быть реализован метод hashCode().
        * index = hash & (n-1) где n размер массива линкд листов, hash - хеш ключа.
        * Число hash побитово умножается на n-1.
        * Эта конструкция позволяет вывести число от 0 до n-1 из хеша ключа.
        * При добавлении новых элементов в Map, массив линкд листов увеличивается.
        * Пары ключ-значение являются узлами. При возникновении коллизии, ссылка на новый узел с
        * новым значением присваивается конечному уже существующему узлу, по этому индексу листа.
        * Таким образом, чтобы найти где находиться нужная нам пара ключ-значение, достаточно вычислить индекс
        * с помощью хеш-функции, и сразу обратиться к нужной паре.
        * В случае коллизии поиск нужного ключа будет производиться как в линкд листе - проходом по каждому узлу. */

        Map<Person, String> map = new HashMap<>();
        Set<Person> set = new HashSet<>();

        // При отсутствии реализации контракта hashCode-equals person1 и person2 считаются разными
        // так как сравниваются по умолчанию по ссылке, а не по-содержимому (по смыслу).
        Person person1 = new Person(1, "Mike");
        System.out.println("person 1 hash: " + person1.hashCode());
        Person person2 = new Person(1, "Mike");
        System.out.println("person 2 hash: " + person2.hashCode());

        map.put(person1, "123");
        map.put(person2, "123");

        set.add(person1);
        set.add(person2);

        System.out.println(map);
        System.out.println(set);
    }
}

class Person{
    private final int id;
    private final String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}