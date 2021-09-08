package com.vlad.advanced;

public class GettersAndSetters {
    /* Причины использования геттеров:
    *   1. Поля должны быть скрыты от пользователя. Изменение имени поля повлечет необходимость изменения
    *   геттера или сеттера, а не кода пользователя.
    *   2. Можно добавить доп. логику (проверку), например не дать указать пустую строку. */

    public static void main(String[] args) {
        Human human1 = new Human();
        human1.setAge(10);
        System.out.println(human1.getAge());
    }
}

class Human {
    private String name;
    private int age;

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Name is empty!");
        }
        // Вызывая this.name мы вызываем human1.name
        // this вызывает объект внутри класса,
        // это способ обратиться внутри класса к объекту этого класса
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
