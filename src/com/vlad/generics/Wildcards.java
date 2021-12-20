package com.vlad.generics;

import java.util.ArrayList;
import java.util.List;

public class Wildcards {
    public static void main(String[] args) {
        List<Animal> listOfAnimal = new ArrayList<>();
        listOfAnimal.add(new Animal(1));
        listOfAnimal.add(new Animal(2));

        test(listOfAnimal);

        List<Dog> listOfDogs = new ArrayList<>();
        listOfDogs.add(new Dog());
        listOfDogs.add(new Dog());

        // test(listOfDogs); error! provided Dog expected Animal
        /* Несмотря на то, что Dog наследуется от Animal, метод test() принимает
         * в параметрах только тип Animal.  */


        test2(listOfDogs); // вызывается переопределенный метод toString()

        test3(listOfDogs);
        // test3(listOfAnimal); provided Animal required Dog

        System.out.println();
        System.out.println("test4(Dogs):");
        test4(listOfDogs);

        System.out.println();
        System.out.println("test4(Animals):");
        test4(listOfAnimal);

        System.out.println();
        System.out.println("test5:");
        test5(listOfAnimal);
        test5(listOfDogs);

        List<SubDog> listOfSubDogs = new ArrayList<>();
        listOfSubDogs.add(new SubDog());
        listOfSubDogs.add(new SubDog());
        test5(listOfSubDogs);
        // test4(listOfSubDogs);   //provided SubDog required Dog and supers
    }

    private static void test(List<Animal> list) {
        for (Animal animal : list) {
            System.out.println(animal);
        }
    }

    private static void test2(List<?> list) {
        for (Object animal : list) {
            System.out.println(animal);
            // (Dog)animal.bark(); ошибка! в этом случае приемы downcasting и upcasting не работают.
        }
    }

    /* extends Dog разрешает подавать на вход метода лист содержащий объекты класса Dog и ниже.
    * Тип переменной в условии цикла должен быть типом наследуемого класса и выше. */
    private static void test3(List<? extends Dog> list) {
        // SubDog dog : list error!!
        for (Dog dog : list) {
            dog.bark();
        }
    }

    /* super Dog разрешает подавать на вход метода лист содержащий объекты выше класса Dog.
     Тип переменной в условии цикла должен быть самого старшего класса. */
    private static void test4(List<? super Dog> list) {
        for (Object animal : list) {
    //  в этом случае приемы downcasting и upcasting также не работают.
            System.out.println(animal.toString());
        }
    }

    private static void test5(List<? super SubDog> list) {
        for (Object animal : list) {
            System.out.println(animal);
            // (Dog)animal.bark(); ошибка! в этом случае приемы downcasting и upcasting не работают.
        }
    }
}