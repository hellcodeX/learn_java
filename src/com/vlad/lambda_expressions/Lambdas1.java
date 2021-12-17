package com.vlad.lambda_expressions;

/* Лямбда выражения появились в 8 версии Java. Это способ передать кусок кода в метод или конструктор,
 а так же обойтись без использования анонимных классов. Они позволяют сократить и упростить некоторые
 участки кода.
  Согласно википедии, лямбда выражение - анонимная функция(метод без названия) без привязки к
   идентификатору.
   (тут аргументы) -> тут тело. Если тело занимает несколько строк, нужно использовать {}.

   В Java 8 везде где раньше приходилось использовать анонимный класс и реализовывать один метод,
    принято использовать лямбда выражения.

    Есть 3 способа передать код в конструктор или метод:
      - с помощью обычного класса реализуя в нем нужный метод
      - с помощью анонимного класса
      - с помощью лямбда выражения

   В лямбде мы должны возвращать значение которое указано в сигнатуре метода.
   Если параметр только один, можно опустить круглые скобки (). Тип параметра можно указывать,
   или не указывать, без разницы.
      Если хотим получить в лямбде доступ к переменной из вне, мы это можем сделать, но переменная
   должна быть final(явная константа) либо просто не менялась после объявления(effectively final - неявно).
   То есть, такое же ограничение как у внутренних классов.
      В отличие от методов, у лямбд нет своей области видимости. У анонимного класса к примеру есть
   свой scope. Лямбды используют область видимости в которых они были созданы.

    Также лямбда выражения можно присваивать переменной. */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambdas1 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Hi from lambdas"));
    }
}

interface Executable {
    void execute();
}

class Runner {
    public void run(Executable e) {
        e.execute();
    }
}

class ExecutableImplementation implements Executable {

    @Override
    public void execute() {
        System.out.println("Hello");
    }
}

class Lambdas2 {
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.run(new ExecutableImplementation()); // 1-й способ
        runner.run(new Executable() { // 2-й способ
            @Override
            public void execute() {
                System.out.println("Hello world");
            }
        });
        runner.run(() -> System.out.println("Hello from lambda")); // 3-й способ
    }
}

interface Executable2 {
    int execute(int x);
}

class Runner2 {
    public void run(Executable2 e) {
        int a = e.execute(10);
        System.out.println(a);
    }
}

class Lambdas3 {
    public static void main(String[] args) {
        Runner2 runner = new Runner2();
        runner.run((int var) -> {  // тип параметра можно указывать или не указывать, без разницы.
            return 1 + var;
        });

        runner.run((var) -> 10 + var);  // если лишь одна строка, можно опустить {}

        runner.run(var -> 30 + var);  // если аргумент один, можно опустить круглые скобки
    }
}

class ComparatorWithLambdas {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Hello");
        list.add("Goodbye");
        list.add("Good");
        list.add("aa");

        list.sort((o1, o2) -> {
            if (o1.length() > o2.length()) return 1;
            else if (o1.length() < o2.length()) return -1;
            else return 0;
        });

        System.out.println(list);
    }
}
