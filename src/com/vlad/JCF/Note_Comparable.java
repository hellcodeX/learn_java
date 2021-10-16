package com.vlad.JCF;

import java.util.*;

public class Note_Comparable {

    /* Позволяет задать естественный порядок нашему собственному классу. Если он не задан, добавление
    * объекта в коллекцию TreeSet вызовет ошибку.
    * Если мы попытаемся вызвать метод sort() у листа без компаратора в качестве второго аргумента,
    * также вылезет ошибка. */

    public static void main(String[] args) {
        List<PersonZ> peopleList = new ArrayList<>();
        Set<PersonZ> peopleSet = new TreeSet<>();

        addElements(peopleList);
        addElements(peopleSet);

        Collections.sort(peopleList);

        System.out.println(peopleList);
        System.out.println(peopleSet);
    }

    private static void addElements(Collection collection) {
        collection.add(new PersonZ(1, "Bob"));
        collection.add(new PersonZ(2, "Tom"));
        collection.add(new PersonZ(3, "Katy"));
    }
}

class PersonZ implements Comparable<PersonZ>{
    private int id;
    private String name;

    public PersonZ(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonZ{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonZ personZ = (PersonZ) o;
        return id == personZ.id && Objects.equals(name, personZ.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public int compareTo(PersonZ o) {
        if (this.id > o.id) {
            return -1;
        } else if (this.id < o.id) {
            return 1;
        } else {
            return 0;
        }
    }
}
