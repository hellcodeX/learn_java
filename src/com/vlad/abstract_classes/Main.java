package com.vlad.abstract_classes;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();

        cat.makeSound();
        dog.makeSound();

        /* Animal не является сущностью, а всего лишь концепцией. Поэтому объекты этого класса
           не должны быть созданы. Его следует сделать абстрактным.
           Abstract используется когда мы хотим создать иерархию классов, но класс родитель не является
           самостоятельным классом. От него обязательно нужно наследоваться и реализовать абстрактные методы,
           если они есть. */
//        Animal animal = new Animal(); Error! Animal is abstract.
    }
}
