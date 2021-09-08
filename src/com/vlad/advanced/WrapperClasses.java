package com.vlad.advanced;

public class WrapperClasses {
    public static void main(String[] args) {
        /* У примитивных типов нет методов, только возможности предлагающая IDE:
         * num.sout даст System.out.println(num);
         * Когда у примитива нужно использовать метод, используются классы-обертки:
         * Double, Float, Long, Integer, Short, Byte, Character, Boolean. */
        int num = 5;
        Integer num2 = new Integer(6);

        /* Чтобы связать примитивный тип и объект этого примитивного типа используются авто распаковка
        * и авто упаковка. Java самостоятельно упакует примитив в соответствующую обертку.*/
        Integer x1 = 111; // Эта инициализация равноценна: Integer x1 = new Integer(111).

        int x2 = x1; // Авто распаковка - x1 превращается в обычный примитив и присваивается x2.



    }
}
