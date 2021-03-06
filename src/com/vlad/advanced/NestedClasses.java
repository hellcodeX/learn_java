package com.vlad.advanced;

public class NestedClasses {
    public static void main(String[] args) {
        Electrocar electrocar = new Electrocar(2);
        electrocar.start();

        Electrocar.Battery.myFloat = 5; // статическая переменная статического класса
        Electrocar.Battery battery = new Electrocar.Battery();
        battery.charge();
    }
}

/* В Java классы можно создавать практически в любом месте: рядом с публичным классом, внутри
* других классов, внутри методов.
* 3 типа вложенных классов:
*   1. Нестатический вложенный класс (обычно приватные).
*       Помогает разграничить логику внутри самого класса, имеет доступ к полям объекта.
*       Является своего рода подобъектом. Обычно используются с private.
*       Нужен когда объект класса сложный, комплексный, и его можно разделить на несколько
*       подобъектов. Ссылку на объект внешнего класса из внутреннего класса можно получить с помощью выражения
*       Внешний_класс.this, например, Person.this .
*   2. Статический вложенный класс (обычно публичные).
*       Не имеет доступа к полям объекта, но есть доступ к полям класса (статическим полям) и к статическим методам.
*       Обычно нужны для использования извне, поэтому используются с модификатором доступа public.
*       Имеет мало общего с самим классом, всего лишь помогает логически сгруппировать класс.
*   3. Вложенные классы, которые находятся в методе.
*       Имеет доступ к нестатическим и нестатическим полям класса и к неявно константным переменным метода или
*       явно константным (final). Похоже на анонимные классы. */

class Electrocar {
    private int id;
    static int z = 3;

    // Нестатический вложенный класс
    private class Motor {
        public void startMotor() {
            System.out.println("Motor is starting... " + id);
        }
    }

    // Статический вложенный класс
    public static class Battery {
        static float myFloat = 0.5f;
        public void charge() {
            System.out.println("Battery is charging...");
        }
    }

    public Electrocar(int id) {
        this.id = id;
    }

    void start() {
        Motor motor = new Motor();
        motor.startMotor();

//        Battery.charge() // ошибка
//        Battery bat = new Battery();
//        bat.charge(); // все верно

        System.out.println("Electrocar " + id + " is starting...");

        final int x = 1;
        int b = 5;
        b = 6; // теперь b не константа

        class SomeClass {
            public void someMethod() {
                System.out.println(x);
                System.out.println(id);
                System.out.println(z);
//                System.out.println(b); // ошибка
            }
        }

        SomeClass sm = new SomeClass();
        sm.someMethod();
    }
}
