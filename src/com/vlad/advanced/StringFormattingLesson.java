package com.vlad.advanced;

public class StringFormattingLesson {
    public static void main(String[] args) {
        System.out.print(1);
        System.out.print(2);
        System.out.print(3);

        System.out.println(1);
        System.out.println(2);
        System.out.println(3);

        String str = "my string";
        System.out.printf("String: %s\n", str);

        System.out.printf("Digit: %5d%d\n", 6, 6);
        System.out.printf("Digit: %-5d%d\n", 6, 6);

        System.out.printf("Floating point number: %f\n", 3.14);
        System.out.printf("Floating point number: %.3f\n", 3.14);
    }
}
