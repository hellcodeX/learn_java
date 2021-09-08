package com.vlad.basics;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        int month;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите число месяца: ");
            month = scanner.nextInt();
            switch (month) {
                case 1:
                    System.out.println("Январь");
                    break;
                case 2:
                    System.out.println("Февраль");
                    break;
                case 3:
                    System.out.println("Март");
                    break;
                case 4:
                    System.out.println("Апрель");
                    break;
                case 5:
                    System.out.println("Май");
                case 6:
                    System.out.println("Июнь");
                case 7:
                    System.out.println("Июль");
                case 8:
                    System.out.println("Август");
                case 9:
                    System.out.println("Сентябрь");
                case 10:
                    System.out.println("Октябрь");
                case 11:
                    System.out.println("Ноябрь");
                case 12:
                    System.out.println("Декабрь");
                default:
                    System.out.println("Введите число от 1 до 12!");
            }
        } while (true);
    }
}

class StringSwitch {
    //    С Java 7 можно перебирать строку в свитче
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите строку: ");
            String str = scanner.nextLine();
            switch (str) {
                case "one":
                    System.out.println("one string");
                    break;
                case "two":
                    System.out.println("two string");
                    break;
                default:
                    System.out.println("такой строки не существует!");
            }
        } while (true);
    }
}
