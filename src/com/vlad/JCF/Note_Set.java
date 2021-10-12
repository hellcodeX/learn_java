package com.vlad.JCF;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Note_Set {
    /* Set с англ. - множество. В отличие от LinkedList хранит в себе только уникальные элементы.
    * Это соотноситься с теорией множеств в математике, где нас интересует набор элементов как множество,
    * не интересует количество элементов, а лиш наличие или отсутствие элемента. */

    public static void main(String[] args) {
        Set<String> hasSet = new HashSet<>(); // не сохраняет порядок
        Set<String> linkedHashSet = new LinkedHashSet<>(); // сохраняет порядок
        Set<String> treeSet = new TreeSet<>(); // хранит элементы в отсортированном порядке
        /*
        Лексикографический порядок:
        a < b < c (0 < 1 < 2)
        aa < ab (00 < 01)
        * */

        hasSet.add("Mike");
        hasSet.add("Katy");
        hasSet.add("Tom");
        hasSet.add("Tom");
        hasSet.add("Tom");
        hasSet.add("George");
        hasSet.add("Donald");

        for (String name : hasSet) {
            System.out.println(name);
        }

        System.out.println("Все классы реализующие Set реализуют toString");
        System.out.println(hasSet);

        if (hasSet.contains("Tom")) {
            System.out.println("hash contains Tom!");
        }
        // contains работает очень быстро благодаря хешированию
        System.out.println("Contains tim?: " + hasSet.contains("Tim")); // false

        if (hasSet.isEmpty()) {
            System.out.println("HashSet is empty!");
        }

        // union - объединение
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            set1.add(i);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int i = 2; i < 8; i++) {
            set2.add(i);
        }

        System.out.println(set1);
        System.out.println(set2);

        Set<Integer> union1 = new HashSet<>(set1);
        union1.addAll(set2);

        System.out.println("addAll:");
        System.out.println(union1);

        // intersection - пересечение множеств
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // retainAll переводиться как сохрани, оставь.
        System.out.println("retainAll:");
        System.out.println(intersection);

        // difference - разность множеств
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);

        System.out.println("removeAll:");
        System.out.println(difference);
    }
}
