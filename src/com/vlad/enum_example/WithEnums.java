package com.vlad.enum_example;

public class WithEnums {
    public static void main(String[] args) {
        /* В переменную animal можно поместить лишь то что определено в enum. В противном случае
        *  вызовется ошибка "Incompatible types". К enum можно обращаются как к статическим полям класса. */
        Animal animal = Animal.CAT;
        System.out.println(animal.getTranslation());
        System.out.println(animal);

        switch (animal) {
            case DOG:
                System.out.println("It's a dog");
                break;
            case CAT:
                System.out.println("It's a cat");
        }

        Season season = Season.SPRING;
        // instanceof проверяет, является ли объект (season) объектом этого класса (Season).
        System.out.println(season instanceof Season);
        System.out.println(season instanceof Enum);
        System.out.println(season instanceof Object);

        /* То-есть enum является по сути своей классом, обладающим своими методами, и на основе которого
        *  создаются объекты. */
        System.out.println(season.getClass());
        System.out.println(Season.SUMMER.getClass());

        System.out.println(season.name());

//      static method valueOf() - из строки получить enum (полезен для ввода).
        Animal dog = Animal.valueOf("DOG");
        System.out.println(dog);
        System.out.println(dog.ordinal());
    }
}

enum Season {
    /* Каждый из этих времен года - объект перечисления Season.
    * Java сама в енаме создает объекты этого енама.
    * Иерархия наследования:
    *   Object -> Enum -> Season
    * От класса Enum наследуются некоторые методы, необходимые для перечислений:
    * name() - название enum в виде строки, полезен когда не хотим вызвать переопределенный метод toString()
    * static method valueOf() - из строки получить enum.
    * ordinal() - получить индекс enum'а. */
    SUMMER, WINTER, AUTUMN, SPRING
}
