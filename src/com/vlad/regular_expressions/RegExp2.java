package com.vlad.regular_expressions;

/* Метод split() принимает на вход регулярное выражение и разбивает строку по нему.
* Метод replaceAll() принимает регулярные выражения, а replace() принимает строку.
* replaceFirst() заменят лиш первое вхождение, и принимает регулярное выражение. */

import java.util.Arrays;

public class RegExp2 {
    public static void main(String[] args) {
        String a = "Hello there hey";
        String[] words = a.split(" ");
        System.out.println(Arrays.toString(words));

        String b = "Hello.there.hey";
        String[] words2 = a.split("\\.");
        System.out.println(Arrays.toString(words));

        String c = "Hello4414there465641hey51445";
        String[] words3 = a.split("\\d+");
        System.out.println(Arrays.toString(words));

        System.out.println("---------");

        String d = "Hello there hey";
        String modifiedString1 = d.replace(" ", ".");
        System.out.println(modifiedString1);

        String e = "Hello421141there1341241hey";
        String modifiedString2 = e.replaceAll("\\d+", "-");
        System.out.println(modifiedString2);

        String f = "Hello421141there1341241hey";
        String modifiedString3 = e.replaceFirst("\\d+", "-");
        System.out.println(modifiedString3);
    }
}
