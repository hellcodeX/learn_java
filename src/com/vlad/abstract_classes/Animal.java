package com.vlad.abstract_classes;

public abstract class Animal {
    public void eat() {
        System.out.println("Animal is eating...");
    }

    /* Только в абстрактных классах можно создавать абстрактные методы.
    * Интерфейс - контракт, то что класс умеет делать.
    * Абстрактный класс - то чем класс является (класс Dog является Animal). */
    public abstract void makeSound();
}
