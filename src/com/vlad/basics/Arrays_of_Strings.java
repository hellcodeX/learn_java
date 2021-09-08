package com.vlad.basics;

public class Arrays_of_Strings {
    public static void main(String[] args) {
        String[] strings = new String[3];
        strings[0] = "str1";
        strings[1] = "str2";
        strings[2] = "str3";

        for (String str : strings) {
            System.out.println(str);
        }
        String s; // по умолчанию указывает на null, однако использовать неинициализированную переменю нельзя.
    }
}
