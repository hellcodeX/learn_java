package com.vlad.basics;

class Break_V1 {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            if (i == 5) {
                break;
            }
            System.out.println(i);
            i++;
        }

        System.out.println("-------------------");
        System.out.println(i);
    }
}

class Break_V2 {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            if (i == 5) {
                break;
            }
            i++;
            System.out.println(i);
        }

        System.out.println("-------------------");
        System.out.println(i);
    }
}

class ContinueLoop {
    public static void main(String[] args) {
        // Нечетные числа
        for (int i = 0; i < 20; i++) {
            if (i%2 == 0) {
                continue;
            }
            System.out.println(i);
        }
    }
}
