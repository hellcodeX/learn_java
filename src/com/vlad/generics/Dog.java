package com.vlad.generics;

public class Dog extends Animal {
    /* По умолчанию здесь:
    *     public Dog() {
        super();
    }
    * Однако у родительского класса нет дефолтного конструктора без параметров,
    * следовательно, возникает ошибка. Поэтому у родительского класса должен быть в данном случае
    * и конструктор без параметров, либо можно в super() передать параметр. */
    public void bark() {
        System.out.println("Dog is barking!...");
    }

    @Override
    public String toString() {
        return "Dog's string!";
    }

    public void eat() {
        System.out.println("Dog is eating!");
    }
}
