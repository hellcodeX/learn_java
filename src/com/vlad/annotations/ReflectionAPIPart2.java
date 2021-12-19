package com.vlad.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectionAPIPart2 {
    /* С помощью рефлексии также можно для объекта класса Class:
    *   - Создавать новые объекты класса (по умолчанию вызывает пустой конструктор) - newInstance()
    *   - Получать методы по сигнатуре - getMethod(...)
    *   - получать конструктор по сигнатуре - getConstructor(...)
    * Для объекта класса Method модно вызывать методы - invoke(). И многое другое.
    * Метод newInstance() можно вызывать не только на объектах класса Class, но и на объектах
    * класса Constructor.
    *   Сигнатура метода в терминах рефлексии это имя и набор типов параметров. Для второго аргумента
    * у метода getMethod() используется Java varargs - можно передать любое число аргументов. */

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        // Название класса1 Название класса2 Название метода
        // Если класс лежит в корне проекта, не нужно указывать полный путь этого класса
        Class classObject1 = Class.forName(scanner.next());
        Class classObject2 = Class.forName(scanner.next());
        String methodName = scanner.next();

        Method m = classObject1.getMethod(methodName, classObject2); // методу в качестве аргумента
        // передаем второй класс
        Object o1 = classObject1.newInstance(); // создать новый объект класса classObject1 и записать в переменную
        Object o2 = classObject2.getConstructor(String.class).newInstance("String value");

        m.invoke(o1, o2); // вызываем метод на объекте o1 с аргументом o2

        System.out.println(o1);
    }
}
