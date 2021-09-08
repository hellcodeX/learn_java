package com.vlad.basics;

import java.util.Scanner;

public class Input {
    String s = new String("Hello world!"); // redundant

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Input something: ");
        String str = s.nextLine();
        System.out.println("Input number: ");
        int myNum = s.nextInt();
        System.out.println("Your input is: " + str + myNum);
    }
}
