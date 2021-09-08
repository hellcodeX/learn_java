package com.vlad.advanced;

// Статические переменные и методы класса (не объекта).
// Статическая переменная принадлежит классу, а не объекту класса,
// и делиться между всеми объектами класса.

/* При запуске программы статические переменные и методы уже существуют.
* Им автоматически будет назначено значение 0 или null (ссылочным переменным), поэтому
* их можно использовать не проинициализировав.
* Статические переменные полезны если методу не нужны переменные объекта, иначе говоря не
* нужно создавать объект класса, для того чтобы воспользоваться методом.
* Пример класс Math, который является не образцом для построения объектов,
* а всего-лишь коллекцией статических методов.
* Статические методы аналогичны функциям (например из языка СИ). */

public class StaticFieldsAndMethods {
    public static void main(String[] args) {
        ClassWithStatic1.description = "description1";
        ClassWithStatic1.getDescription();

        ClassWithStatic1 withStatic1 = new ClassWithStatic1();
        ClassWithStatic1 withStatic2 = new ClassWithStatic1();
        System.out.println(withStatic2.getCount());
        ClassWithStatic1 withStatic3 = new ClassWithStatic1();
        ClassWithStatic1 withStatic4 = new ClassWithStatic1();
        System.out.println(withStatic4.getCount());
        // Так можно делать, но это не имеет смысла.
        // Правильно - ClassWithStatic1.description
        System.out.println(withStatic1.description);
        System.out.println(ClassWithStatic1.nonInitialized);

    }
}

class ClassWithStatic1 {
    String name;
    public static String description;
    public static int nonInitialized;
    public static int count;

    public ClassWithStatic1() {
        count++;
    }

    public int getCount() {
        return count;
    }

    // Нельзя обратиться к переменной объекта (не статической),
    // из статического метода.
    public static void getDescription() {
        System.out.println(description);
    }
}
