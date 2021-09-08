package com.vlad.Intefraces;

public class Test {
    public static void main(String[] args) {
        Animal animal1 = new Animal(1);
        Person person1 = new Person("Max");
        animal1.sleep();
        person1.sayHello();

        animal1.showInfo();
        person1.showInfo();

        System.out.println("//////////////////////////////////////////");

        Info[] info = new Info[2];
        info[1] = animal1;
        info[0] = person1;

        for (Info inf : info) {
            inf.showInfo();
        }
    }
}
