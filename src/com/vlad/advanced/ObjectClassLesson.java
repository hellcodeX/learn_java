package com.vlad.advanced;

public class ObjectClassLesson {
    public static void main(String[] args) {
        MyClass obj = new MyClass(10);
        /* Благодаря тому что все создаваемые объекты наследуются от object,
        * нам доступен метод toString() а также множество других методов, несмотря на то что их нет в нашем классе.
        * Этот метод toString() возвращает хеш-код нашего созданного объекта. */
        System.out.println(obj);
        System.out.println(obj.toString()); // равноценно предыдущему
    }
}

class MyClass {
    private int number;

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    public MyClass(int number) {
        this.number = number;
    }
}
