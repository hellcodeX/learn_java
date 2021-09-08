package com.vlad.FileIO.Serialization;

import java.io.Serializable;

public class TransientField implements Serializable {
    /* transient (временные поля) при десериализации
     получат значение null в случае со ссылочными типами, и 0 - примитивными, так как такие значения по умолчанию
     имеют поля класса. */
    private int id;
    private transient String name; // не сериализовывать это поле

    public TransientField(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}

class Main {
    public static void main(String[] args) {

    }
}
