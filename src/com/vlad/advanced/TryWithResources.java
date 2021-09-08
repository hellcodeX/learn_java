package com.vlad.advanced;

import com.vlad.FileIO.Serialization.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class TryWithResources {
    public static void main(String[] args) {
        /* Если класс (в стандартной библиотеке чаще всего - классы по иерархии выше) реализует интерфейс Closable,
        он обязан реализовывать метод close(). Этот метод позволяет использовать "try with resources". */

        // First run FileIO -> Serialization -> WriteMassive.java -> WriteMassive2  example to write massive.
        try (var ois = new ObjectInputStream(new FileInputStream(".\\files_dir\\Persons.bin"))) {
            Person[] people = (Person[]) ois.readObject();
            System.out.println(Arrays.toString(people));
            // Позволяет не закрывать потоки вручную. Они действительны в пределах блока try.
            //ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
