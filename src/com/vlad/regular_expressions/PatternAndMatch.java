package com.vlad.regular_expressions;

/* Классом Pattern является само регулярное выражение. Класс Match использует паттерн для проведения
* операций над строкой.
*   Мы не можем создавать класс Pattern напрямую, используя new, так как конструктор
* является приватным. Этот класс использует паттерн проектирования Factory Method, и заключается в
* том что мы ограничиваем создание класса с помощью конструктора и взамен даем статический метод,
* который возвращает новый объект класса.
*
* find() - ищет очередное соответствие в тексте, и при нахождении возвращает true.
* group() - возвращает то что было найдено методом find() если вызывать без аргументов. В таком
* случае мы получаем всю подстроку, которая совпала с нашим регулярным выражением.
* Мы модем передать этому аргументу число - id группы. Группа в регулярных выражениях - строка,
* которая находится в круглых скобках (). Их может быть любое количество. У каждой группы есть
* уникальный id, который начинается с 1, увеличивается слева на право, и идет в глубину.
*     1
* ((2) (3))
*
*   1
* ((2)) (3) */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAndMatch {
    public static void main(String[] args) {
        String text = "ASafadas afa bla bla myMail@gmail.com John OK! Foo myMfafail@yandex.ru  bar";

        Pattern email = Pattern.compile("(\\w+)@(yandex|gmail)\\.(ru|com)");
        Matcher matcher = email.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(2));
        }
    }
}
