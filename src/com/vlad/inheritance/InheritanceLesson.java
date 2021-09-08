package com.vlad.inheritance;

public class InheritanceLesson {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println(animal.getClass());
        animal.eat();
        animal.sleep();

        Dog dog = new Dog();
        System.out.println(dog.getClass());
        dog.eat();
        dog.sleep();
        dog.bark();
        dog.showName();
    }
}
