package com.vlad.Intefraces;

/* В старых версиях Java у методов интерфейса не может быть тела.
* В новых версиях у методов интерфейса может быть дефолтная реализация.
* (public default void showInfo(){тело}) */
public interface Info {
    public void showInfo(); // В интерфейсе без default может быть лиш сигнатура метода.
}
