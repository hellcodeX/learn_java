package com.vlad.annotations;

import com.vlad.annotations.MethodInfo;

public class Test {
    @MethodInfo(author = "Alex", dateOfCreation = 2019, purpose = "Print Hello World")
    public void printHelloWorld() {
        System.out.println("Hello world!");
    }
}
