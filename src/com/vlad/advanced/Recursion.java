package com.vlad.advanced;

public class Recursion {
    /* Рекурсия - вызов метода в теле этого же метода.
     * Чтобы рекурсия была полезной нужен base case (условие выхода).
     * Условие должно находится перед вызовом функции. */
    public static void main(String[] args) {
        someMethod(5);
        //someMethod2(100); // don't work because of x - local variable.

        int maxNumber = 10;
        System.out.print("Fibonacci Series of " + maxNumber + " numbers: ");
        for (int i = 0; i < maxNumber; i++) {
            System.out.print(fibonacciRecursion(i) + " ");
        }
    }

    private static void someMethod(int n) {
        System.out.println(n);

        if (n == 0) {
            return;
        }
        someMethod(n - 1);
    }

    private static void someMethod2(int n) {
        int x = 1;
        System.out.println(n);

        if (x > n) {
            return;
        }
        someMethod2(x += x);
    }

    public static int fibonacciRecursion(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        return fibonacciRecursion(n-2) + fibonacciRecursion(n-1);
    }
}
