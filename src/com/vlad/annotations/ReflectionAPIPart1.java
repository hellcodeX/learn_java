package com.vlad.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionAPIPart1 {
    /* У каждого класса есть:
     *   name (имя класса)
     *   package name (имя пакета)
     *   List of attributes (список полей)
     *   List of methods (список методов)
     *   и прочее
     *   Для всего этого есть класс Class.
     *
     *   Все классы, которые мы создаем в Java (и встроенные классы тоже) можно рассматривать как
     * экземпляры (объекты) класса Class. То есть все объекты класса Class - это конкретные классы со своим
     * названием, методами и полями. Следовательно, все инструменты ООП мы можем применить к самим
     * классам как к сущностям - это и называется рефлексией. Класс Class - служебный класс, экземпляры
     * которого (Java классы) хранят конкретную информацию о конкретном классе.
     *
     *   Доступ к объекту класса Class (вернуть объект класса Class) можно получить 3-ма способами:
     *       - Class c = MyClass.class;  - по самому классу
     *       - Class c = obj.getClass;   - по объекту класса (obj экземпляр класса  MyClass)
     *       - Class c = Class.forName("ua.vlad.MyClass"); - по названию класса (полное имя класса)
     *
     * getMethods() возвращает массив объектов Method.
     * getField() возвращает массив объектов Field, принимает в счет инкапсуляцию - возвращает публичные поля.
     * getDeclaredField() возвращает даже приватные поля.
     * getAnnotations() вернет массив объектов Annotation.
     *  */

    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Person();

        Class personClass = Person.class;
        Class personClassFromObject = person.getClass();
        Class personClassFromFullNameOfClass = Class.forName("com.vlad.annotations.Person");

//        displayMethods(personClass);
//        getFields(personClass);
        getAnnotations(personClass);
    }

    public static void displayMethods(Class c) {
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println("Name: " + method.getName() + ", " + "ReturnType: " + method.getReturnType() + ", " +
                    "Parameter types: " + Arrays.toString(method.getParameterTypes()));
        }
    }

    public static void getFields(Class c) {
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("FieldName: " + field.getName() + ", " + "FieldType: " + field.getType());
        }
    }

    public static void getAnnotations(Class c) {
        Annotation[] annotations = c.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Author) {
                System.out.println("Yes this class have \"Author\" annotation");
            }
        }
    }
}
