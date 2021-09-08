package com.vlad.FileIO.Serialization;

import java.io.*;

public class ReadObject {
    public static void main(String[] args) {

        try {
            // Записывает в файл последовательность байт
            FileInputStream fileInputStream = new FileInputStream(".\\files_dir\\Persons.bin");
            // Преобразует объект в последовательность байт
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Person p1 = (Person) objectInputStream.readObject();
            Person p2 = (Person) objectInputStream.readObject();

            System.out.println(p1);
            System.out.println(p2);

            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) { // ClassNotFoundException если нету класса Person
            e.printStackTrace();
        }
    }
}
