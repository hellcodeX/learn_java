package com.vlad.basics;

public class MultidimensionalArrays {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},
                            {4,5,6},
                            {7,8,9}};

        Display(matrix);
    }

    public static void Display(int[][] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.print(mas[i][j]);
            }
            System.out.println();
        }
    }
}
