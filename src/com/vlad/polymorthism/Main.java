package com.vlad.polymorthism;

public class Main {
    /* Полиморфизм (в переводе с древнегреческого - многообразие форм) - способность метода обрабатывать
     данные разных типов. */
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        animal.eat(); // Animal is eating...

        // класс Dog унаследовал метод класса Animal
        dog.eat(); // Animal is eating...
        dog.bark(); // "Dog is barking..."

        /* Благодаря наследованию можно привести тип Dog к типу Animal (upcasting), что
        * является проявлением полиморфизма. Однако мы имеем доступ лишь к методам,
        * имеющимся в классе к которому выполняется приведение.  */
        Animal animal2 = new Dog(); // upcast class Dog to Animal
        // animal2.bark(); Cannot resolve method bark() in Animal.


        /* Но при приведении производного класса к базовому - вызываются
        * переопределенные, в классах наследниках, версии методов базового класса,
        * если таковые имеются. Это возможно благодаря "позднему связыванию".  */
        Animal animal3 = new Cat(); // upcast class Cat to Animal
        animal3.eat(); // Cat eat fish...

        System.out.println("////////////////////////////////////");

        Animal animalToMethod = new Animal();
        Cat catToMethod = new Cat();

        testMethod(animalToMethod);
        testMethod(catToMethod);

        /* Upcasting (восходящее преобразование) происходит автоматически (от потомка к родителю).
        Downcasting (нисходящее преобразование) происходит только явно. (от родителя к потомку). */

        // Примеры с downcasting
        Dog mydog = new Dog();
        Animal ani3 = mydog; // up to Animal

        Dog mydog2 = (Dog)ani3; // down to Dog
        mydog2.bark();

        // Однако
        Animal a = new Animal();
        Dog sparky = (Dog)a;
        // sparky.bark(); // вызовет ошибку рантайма, поскольку в объекте класса Animal нет метода bark().
    }
    /* Полиморфизм позволяет не создавать аналогичные методы для всех классов,
    * и избежать тем самым дублирования кода. */
    public static void testMethod(Animal animal) {
        animal.eat();
    }

}
