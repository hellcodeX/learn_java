package com.vlad.lambda_expressions;

/* Для лямбда выражений нет разницы, массив это или лист. Метод stream() превращает коллекцию или массив
* в поток, над которым уже можем проводить все необходимые нам преобразования.
*  Метод map пришел из функциональных языков программирования. Он берет каждый элемент из набора данных
* и сопоставляет иму новый элемент. В качестве аргумента принимает логику сопоставления. Map
* переводится как отображение, и это понятие пришло из теории множеств. Операция отображения множеств
* берет элементы одного множества, и по некому правилу сопоставляем элемент из нового множества.
*
* Метод map() берет на вход набор элементов и итерируется по нему. Также этот метод возвращает нам поток,
* поэтому, чтобы превратить поток в массив или коллекцию, следует вызвать toArray() / collect().
* Коллект в качестве аргумента принимает один из коллекторов статического класса Collectors.
* toList() превращает поток в список.
*
* Метод filter() позволяет получить подмножество элементов из общего множества элементов.
* Возвращает true если элемент соответствует нашему критерию, и false если не соответствует.
*
* Метод forEach() проходится по всем элементам коллекции или массива.
* Если в теле лямбда выражения мы ничего не делаем кроме как вызываем один метод - можем ее сократить
* использовав method reference ( System.out::println ). В этом случае джава сама понимает что, на вход
* println() следует передать аргумент лямбда выражения. Так мы передаем просто указатель на метод.
* :: дает понять что это именно указатель на метод.
*
* Метод reduce() уменьшает набор данных до одного элемента. Принимает 2 аргумента:
* аккумулятор и текущий элемент. Аккумулятор принято называть acc. Он сохраняет в себе значение,
* возвращаемое в лямбде, после каждой итерации.
* getAsInt() - получить значение из reduce() для массива.
* get() - получить значение из reduce() для коллекции. Если в результате reduce может не вернуться ничего,
* то следует сделать проверку isPresent().
* По умолчанию, значение аккумулятора равно значению первого элемента в массиве или коллекции.
* Чтобы указать другое значение reduce() в качестве первого аргумента нужно передать начальное значение
* аккумулятора, а вторым уже логику. В этом случае мы можем обратиться без приведения к целому числу
* ( getAsInt() ), так как джава понимает и так что будет возвращено целое число. Также если не указывать
* начальное значение аккумулятора, итерация начнется со второго элемента. */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdasExamples {
    public static void main(String[] args) {
        int[] arr = new int[10];
        List<Integer> list = new ArrayList<>();

        fillArr(arr);
        fillList(list);

        System.out.println(list);
        System.out.println(Arrays.toString(arr));

//        for (int i = 0; i < 10; i++) {
//            arr[i] = arr[i] * 2;
//            list.set(i, list.get(i) * 2);
//        }

        // map method
        int[] arr1 = Arrays.stream(arr).map(a -> a * 2).toArray();
        List<Integer> list1 = list.stream().map(a -> a * 2).collect(Collectors.toList());

        System.out.println(list1);
        System.out.println(Arrays.toString(arr1));

        System.out.println(list.stream().map(a -> 5).collect(Collectors.toList()));

        // filter method
        System.out.println(list.stream().filter(a -> a < 7).collect(Collectors.toList()));

        // forEach method
        list.stream().forEach(System.out::println);

        // reduce method
        int[] massiv1 = {1, 2, 3};

        System.out.println(Arrays.stream(massiv1).reduce((acc, b) -> acc + b).getAsInt());
        System.out.println(list.stream().filter(a -> a < 4).reduce((acc, x) -> acc * x * x).get());

    }

    public static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }

    public static void fillArr(int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
    }
}


