package com.vlad.regular_expressions;

/* Регулярные выражения - язык позволяющий описывать паттерны в тексте и являются очень мощным инструментом
 для работы с текстом.
  matches() возвращает true если строка совпадает со строкой в аргументе, false если нет.
  Аргументом может быть не только строка, но и регулярное выражение (паттерн).

   Регулярные выражения:
        \\ обозначает что это не буква, а спец. символ. Они переводят букву в спец. символ, и обратно
        спец. символ в букву. На самом деле экранирует просто \, но его также нужно экранировать.
        \\d - одна цифра  = [0-9]
        \\w - одна буква = [a-zA-z]
        Все что ниже так же спецсимволы. Поэтому если они есть в строке, мы должны их экранировать \\.
        + - 1 или более
        * - 0 или более
        ? - символов идущий до него может быть или не быть (0 или 1)

        ( | | ) - описывают вещи которые, могут быть. Разделяются они символом |

        (a|b|c|d|e|f|g) - громоздко, но (com|ru) - бывают очень полезны
        [a-zA-z] - описывает множество всех англ. букв
        [0-9] - цифра от 0 до 9
        [abc] == (a|b|c)
        Внутри квадратны скобок помимо - можно использовать символ отрицания ^
        [^abc] - все символы кроме a b c
        [^a-z] - все символы кроме маленьких английских букв

        . - обозначает любой один символ (по умолчанию спец символ)
        .+ - обозначает множество каких либо символов

        {2} - позволяет задать сколько символов должно быть в определенном месте (\\d{2})
        {2, } - от 2 символов до бесконечности
        {2, 4} - от 2 до 4 символов

        шпаргалка - https://regexlib.com/CheatSheet.aspx
   */

public class RegExp1 {
    public static void main(String[] args) {
        String a = "1234";
        System.out.println(a.matches("1234")); // true
        System.out.println(a.matches("12345")); // false

        System.out.println("--------------");

        System.out.println("1".matches("\\d")); //true
        System.out.println("11".matches("\\d")); // false
        System.out.println("11".matches("\\d+")); // true
        System.out.println("".matches("\\d*")); // true

        System.out.println("--------------");

        System.out.println("-1".matches("\\d")); // false
        System.out.println("-1".matches("-\\d")); // true

        System.out.println("--------------");

        System.out.println("1".matches("-?\\d")); // true
        System.out.println("-1".matches("-?\\d")); // true

        System.out.println("--------------");

        System.out.println("+1".matches("-?\\d")); // false

        System.out.println("+11".matches("(-|\\+)?\\d*")); // true
        System.out.println("-11".matches("(-|\\+)?\\d*")); // true
        System.out.println("11".matches("(-|\\+)?\\d*")); // true

        System.out.println("--------------");

        System.out.println("f1231".matches("([a-z]|-|\\+)?\\d*")); // true
        System.out.println("fgasga1231".matches("([a-z]+|-|\\+)?\\d*")); // true

        System.out.println("--------------");

        System.out.println("asdf".matches("[^abc]*")); // false
        System.out.println("hello".matches("[^abc]*")); // true

        System.out.println("--------------");

        System.out.println("http://www.google.com".matches("https?://www\\..+\\.(com|ru)")); // true

        System.out.println("--------------");

        System.out.println("123".matches("\\d{2}")); // false
        System.out.println("123".matches("\\d{3}")); // true
    }
}
