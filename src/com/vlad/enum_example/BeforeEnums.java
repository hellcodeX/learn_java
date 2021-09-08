package com.vlad.enum_example;

/* Почему-то добавление пакета под названием "enum" делает невозможным создание джава класса. */
public class BeforeEnums {
    public static final int DOG = 0;
    public static final int CAT = 1;
    public static final int FROG = 2;

    public static void main(String[] args) {
        /* Проблема 1 - в int можем записать любое число. Даже то которое не предусмотрено в switch.
        *  Проблема 2 - надо смотреть какое число чему соответствует, назначить числа вручную.
        * Enum накладывает на это все ограничения, делает решение таких задач более понятным. */
        int animal = FROG;
        switch (animal) {
            case DOG:
                System.out.println("It's a dog");
                break;
            case CAT:
                System.out.println("It's a cat");
                break;
            case FROG:
                System.out.println("It's a frog");
                break;
            default:
                System.out.println("It's not an animal");
        }
    }
}
