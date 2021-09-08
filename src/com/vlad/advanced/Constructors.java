package com.vlad.advanced;

public class Constructors {
    public static void main(String[] args) {
        PersonConstructor p1 = new PersonConstructor();
        PersonConstructor p2 = new PersonConstructor("Max", 15);

        System.out.println(p2.getName());
        System.out.println(p2.getAge());
    }
}

class PersonConstructor {
    private String name;
    private int age;

// Конструктор инициализирует поля объекта
// По умолчанию вызывается "пустой конструктор"
// "Пустой конструктор" - не принимает параметров и имеет пустое тело.
    public PersonConstructor () {
        System.out.println("Конструктор без параметров");
    }

    public PersonConstructor (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
