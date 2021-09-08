package com.vlad.basics;

public class PrimitiveTypes {

    public static void main(String[] args) {
        Byte aByte = 127; // OK!
        // Byte aByte = 128; // ERROR 128 is integer!

        System.out.println(aByte.getClass());
    }
        // integer types
    short myShort = 335; // 16 bit
    int myInt = 111; // 32 bit
    long myLong1 = 111l; // 64 bit
    long myLong2 = 111L; // 64 bit
    byte myByte = 127; // -128 to 127
    // byte myByte = 128; // error!

        // real types
    float myFloat1 = 1.0f;
    float myFloat2 = 1.0F;
    double myDouble = 1.0;

    char aChar = 'a';
    boolean aBoolean1 = true;
    boolean aBoolean2 = false;


}
