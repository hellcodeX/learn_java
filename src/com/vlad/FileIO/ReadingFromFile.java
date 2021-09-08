package com.vlad.FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ReadingFromFile {
    //  C:\Users\User\IdeaProjects\learn_java1\src\com\vlad\read_file\myfile.txt

    /* Можно указывать также относительный путь. Если файл лежит в корневой папке проекта можно просто в качестве
     * пути указать его имя. */

    /* Разные ОС могут использовать разные разделители в путях. Например, в windows "\", в Unix подобных ОС "/".
    Чтобы код был универсальным и работал на разных ОС необходимо, вместо того чтобы указывать разделитель самым,
    делегировать это джаве. Джава будет сама подставлять разделитель. */

    public static void main(String[] args) throws FileNotFoundException {
        String separator = File.separator;
        System.out.println("Separator is: " + separator);

        String path = "C:" + separator + "Users" + separator + "User" + separator +
                "IdeaProjects" + separator + "learn_java1" + separator + "src" + separator + "com" +
                separator + "vlad" + separator + "FileIO" + separator + "myfile.txt";

        File file = new File(path);

        /* Объекту класса Scanner неважно с чем работать: с входным потоком или файлом, главное чтобы был какой-то
        * поток данных, а класс Scanner будет считывать этот поток. Необходимо при этом обрабатывать случай
        * если файл не найден. */
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        scanner.close(); /* в конце программы обязательно нужно закрывать сканер, чтобы освободились ресурсы и
        поток оставался открытым. */

        String path2 = "C:" + separator + "Users" + separator + "User" + separator +
                "IdeaProjects" + separator + "learn_java1" + separator + "src" + separator + "com" +
                separator + "vlad" + separator + "read_file" + separator + "numbers_in_one_line.txt";

        File file2 = new File(path2);
        Scanner scanner2 = new Scanner(file2);

        String wholeLine = scanner2.nextLine();
        String[] words = wholeLine.split(" ");

        System.out.println(Arrays.toString(words));

        int counter = 0;
        int[] numbers = new int[4];
        for (String word : words) {
            numbers[counter++] = Integer.parseInt(word);
        }
        System.out.println(Arrays.toString(numbers) + " count: "+ counter);

        scanner2.close();
    }
}
