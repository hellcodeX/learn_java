package com.vlad.FileIO.Serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {
        Person p1 = new Person(1, "John");
        Person p2 = new Person(5, "Alex");

        try {
            // Записывает в файл последовательность байт
            FileOutputStream fileOutputStream = new FileOutputStream(".\\files_dir\\Persons.bin");
            // Преобразует объект в последовательность байт
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(p1);
            objectOutputStream.writeObject(p2);
            System.out.println("Written is success!");

            objectOutputStream.close(); // иначе ничего не запишется
            fileOutputStream.close(); // запишет даже если не закрывать хмм...
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
