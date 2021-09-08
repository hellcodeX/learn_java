package com.vlad.FileIO.Serialization;

import java.io.*;

public class WriteMassive {
    public static void main(String[] args) {
        Person[] people = {
                new Person(1, "Vlad"),
                new Person(2, "Max"),
                new Person(3, "Alex")
        };
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(".\\files_dir\\Persons.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeInt(people.length); // 1-й способ

            for (Person p : people) {
                objectOutputStream.writeObject(p);
            }

            System.out.println("Written is success!");

            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class WriteMassive2 {
    public static void main(String[] args) {
        Person[] people = {
                new Person(1, "Vladfff"),
                new Person(2, "Max"),
                new Person(3, "Alex")
        };
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(".\\files_dir\\Persons.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                objectOutputStream.writeObject(people); // 2-й способ

            System.out.println("Written is success!");

            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
