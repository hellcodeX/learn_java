package com.vlad.advanced;
/* В каждом файле должен быть 1 публичный класс, имя которого
* будет соответствовать имени java файла.
* Класс это шаблон, общее понятие, чертёж.
* Класс - это тип данных создаваемый нами. */

/* У класса могут быть:
*   1. Данные (поля)
*   2. Действия которые он может совершать (методы) */

public class ClassesAndObjects {
    public static void main(String[] args) {
        // Тип данных имя = создание объекта
        // Переменную person1 ссылаем на новый объект класса Person
        Person person1 = new Person();

        // Нарушается принцип инкапсуляции,
        // лучше использовать сеттеры и геттеры
        person1.age = 15;
        person1.name = "Adam";
        System.out.println(person1.name + person1.age);

        Person person2 = new Person();
        person2.age = 20;
        person2.name = "John";
        System.out.println(person2.name + person2.age);

        person2.speak();
    }
}

class Person{
    String name;
    int age;

    void speak() {
        System.out.println("name " + name + "age " + age);
    }
}

