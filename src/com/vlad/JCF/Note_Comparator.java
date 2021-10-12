package com.vlad.JCF;

import java.util.*;

public class Note_Comparator {
    /* Контракт Comparable позволяет задать принцип сортировки объектов хранящихся в коллекциях.
     * Применяется к коллекциям которые сохраняют в себе порядок: ArrayList, LinkedList, а также
     * поддерживают сортировку внутри себя: TreeSet, TreeMap.
     *  */

    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();

        animals.add("dog");
        animals.add("cat");
        animals.add("frog");
        animals.add("bird");

        Collections.sort(animals, new StringLengthComparator()); // по умолчанию алгоритм сортировки - quick sort
        System.out.println(animals);

        List<Integer> ints = new ArrayList<>();

        ints.add(5);
        ints.add(0);
        ints.add(500);
        ints.add(100);

        Collections.sort(ints, new BackwardsIntegerComparator());
        System.out.println(ints);

        // С использованием анонимного класса
        List<String> animals2 = new ArrayList<>();

        animals2.add("dog");
        animals2.add("cat");
        animals2.add("frog");
        animals2.add("bird");

        Collections.sort(animals2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return -1;
                } else if (o1.length() < o2.length()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(animals2);

        List<PersonX> people = new ArrayList<>();
        people.add(new PersonX(1, "Bob"));
        people.add(new PersonX(2, "Katy"));
        people.add(new PersonX(3, "Mike"));

        Collections.sort(people, new Comparator<PersonX>() {
            @Override
            public int compare(PersonX o1, PersonX o2) {
                if (o1.getId() > o2.getId()) {
                    return 1;
                } else if (o1.getId() < o2.getId()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println(people);
    }
}

class StringLengthComparator implements Comparator<String> {
    /* Существует конвенция:
     *  o1 > o1 => 1
     *  o1 < o2 => -1
     *  o1 == o2 => 0
     *  Примеры:
     *   compare(2, 1) => 1
     *   compare(1, 2) => -1 */

    @Override
    // Сортировка по длине строки
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        } else {
            return 0;
        }
    }
}

class BackwardsIntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) {
            return -1; // -1 перемещает элемент вправо
        } else if (o1 < o2) {
            return 1; // 1 перемещает элемент влево
        } else {
            return 0; // 0 оставляет элемент на своем месте
        }
    }
}

class PersonX {
    private int id;
    private String name;

    public PersonX(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PersonX{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
