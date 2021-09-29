package com.vlad.JCF;

import java.util.ArrayList;

/* ArrayList реализует функционал динамического массива - расширяется при добавлении
    новых элементов. Эффект динамичности достигается созданием нового массива размером в 2 раза
    больше предыдущего, и копированием элементов старого массива в новый. */
public class Note_ArrayList {
    public static void main(String[] args) {
        // В обобщениях можно указывать только ссылочные типы (не примитивы).
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList.add(i);
        }
        //System.out.println(Arrays.toString(arrayList)); - ошибка, это не массив а лист.
        System.out.println(arrayList);
        System.out.println(arrayList.get(2));
        System.out.println(arrayList.size());

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        for (Integer x : arrayList) {
            System.out.println(x);
        }

        arrayList.remove(2); // удаление неэффективно
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        
    }
}
