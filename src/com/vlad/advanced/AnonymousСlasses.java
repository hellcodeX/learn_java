package com.vlad.advanced;

public class AnonymousСlasses {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();

        OtherAnimal otherAnimal = new OtherAnimal();
        otherAnimal.eat();

        Animal animal2 = new Animal() {
            @Override
            public void eat() {
                System.out.println("Override eat in anonymous class!");
            }
        };
        animal2.eat();

        // More useful example of anonymous classes.

        // За кулисами создается класс реализующий интерфейс, и объект этого класса присваивается интерфейсу.
        Damageable damageable = new Damageable() {
            @Override
            public void dmg() {
                System.out.println("Take damage!");
            }
        };
        damageable.dmg();
    }
}

interface Damageable {
    public void dmg();
}

class Animal {
    public void eat() {
        System.out.println("Animal is eating...");
    }
}

class OtherAnimal extends Animal {
    @Override
    public void eat() {
        System.out.println("Other animal is eating...");
    }
}
