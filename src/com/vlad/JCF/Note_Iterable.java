package com.vlad.JCF;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Note_Iterable {
    /* Интерфейс Iterable дает понять джаве что эта сущность является коллекцией, и по ней можно
    * проходится. Он позволяет проходиться по элементам с помощью foreach.
    * Итератор хранит в себе указатель на элемент объекта. Коды мы первый раз получаем итератор,
    * указатель указывает на место до первого элемента.
    * Метод next() перемещает указатель на 1 элемент вперед.
    * На последней итерации hasNext() выдает false, так как следующего элемента нет. */

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(3);

        // Работа с итераторами напрямую. В итераторе описана логика прохождения по элементам коллекции.
        Iterator<Integer> integerIterator = list.iterator();
        while (integerIterator.hasNext())
            System.out.println(integerIterator.next());

        System.out.println("=====================================");

        /* Foreach появился в Java 5. Он является абстракцией над итераторами которые лежат в глубине
        * реализации коллекций. */
        for (int x : list) {
            System.out.println(x);
        }

        /* Единственное чем отличаются эти 2 способа - в итераторе мы можем удалять элементы, одновременно
        * итерируя по этим элементам, так как мы удаляем элемент на который указывает указатель.
        * В foreach мы не можем изменять коллекцию в тот момент когда проходимся по ней, поскольку
        * здесь мы можем удалить любой элемент из коллекции с помощью remove() и это может привести
        * к неопределенному состоянию. Поэтому было решено ограничить эту возможность. */
    }
}

class IterableClass implements Iterable {
    @Override
    public Iterator iterator() {
        return null;
    }
}
