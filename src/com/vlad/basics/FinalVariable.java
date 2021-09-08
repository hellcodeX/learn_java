package com.vlad.basics;

public class FinalVariable {
    public static void main(String[] args) {
        // Константы могут быть переменными в методе, не только класса.
        final int NUM = 5;
        System.out.println(NUM);
        // NUM = 5; ERROR!
    }
}

class FinalKeyword {
    // final используется для обозначения переменной которая должна быть однажды проинициализирована,
    // и не может изменяться в дальнейшем.
    public final int CONSTANT = 5;
    // Зачастую переменные final являются static, поскольку объекты не могут изменять ее значение.
    // Для всех объектов она будет иметь одно и то же значение, и не имеет смысла дублировать ее,
    // поскольку это приводит к растрате памяти.
    public static final double PI = 3.14;
}
