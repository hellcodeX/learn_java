package com.vlad.FileIO.Serialization;

import java.io.*;
import java.util.Arrays;

public class ReadMassive {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(".\\files_dir\\Persons.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            int personCount = objectInputStream.readInt(); // 1-й способ
            Person[] people = new Person[personCount];

            for (int i = 0; i < personCount; i++) {
                people[i] = (Person) objectInputStream.readObject();
            }

            objectInputStream.close();
            fileInputStream.close();

            System.out.println(Arrays.toString(people));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class ReadMassive2 {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(".\\files_dir\\Persons.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Person[] people = (Person[]) objectInputStream.readObject(); // 2-й способ

            objectInputStream.close();

            System.out.println(Arrays.toString(people));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
