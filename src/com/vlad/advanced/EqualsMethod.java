package com.vlad.advanced;

public class EqualsMethod {
    public static void main(String[] args) {
        AnimalA animal1 = new AnimalA(1);
        AnimalA animal2 = new AnimalA(1);

        System.out.println(animal1 == animal2);

        /*
         Сравнение выдаст false. == сравнивает ссылки на объекты, а не сами объекты.
         == - работает только для примитивных типов данных. Чтобы сравнить объекты структурно, не по указателям,
         следует переопределять метод equals() класса Object. По умолчанию метод equals() аналогичен сравниванию с ==.
        */

        AnimalB animal3 = new AnimalB(1);
        AnimalB animal4 = new AnimalB(1);

        System.out.println(animal3.equals(animal4));

        /* String и String Pool.
         * Строки ВСЕГДА нужно сравнивать методом equals(). Когда строка создается
         * в первый раз, она помещается в String Pool. Таким образом экономиться память, а также
         * ресурсы и время на создание нового объекта класса String.
         * Однако при сравнении нестатических строк применение == недопустимо, так как это
         * сравнивает ссылки на строки. Во избежание ошибок всегда используется equals(). */

        String str1 = "word";
        String str2 = "word";

        System.out.println("Strings:");
//        System.out.println("str1 == str2: " + str2 == str1); // false (порядок операций дает о себе знать!)
        System.out.println("str1 == str2: " + (str2 == str1)); // true

        // Так кеширования не происходит
        String str3 = new String("word");
        String str4 = new String("word");

        System.out.println(str3 == str4); // false
    }
}

class AnimalA {
    private int id;

    public AnimalA(int id) {
        this.id = id;
    }
}

class AnimalB {
    private int id;

    public AnimalB(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        AnimalB animal = ((AnimalB) obj);
        return this.id == animal.id;
    }
}
