package com.vlad.FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteToFile {
    public static void main(String[] args) throws FileNotFoundException {
        String separator = File.separator;
        // Относительный путь
        String path = "." + separator + "src" + separator + "com" +
                separator + "vlad" + separator + "FileIO" + separator + "file_for_write.txt";

        File file = new File(path);
        PrintWriter printWriter = new PrintWriter(file);

        printWriter.println("Hello world 111 file!");

        // Если забыть закрыть, ничего не запишется.
        printWriter.close();
    }
}
