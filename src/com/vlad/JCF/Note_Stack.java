package com.vlad.JCF;

import java.util.Stack;

public class Note_Stack {
    /*
    * Stack - FILO (First In Last Out)
    * Stack наследуется от устаревшего класса Vector (который сам по себе не используется, ибо устарел).
    * ArrayList заменяет Vector.
    *  */

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(3);
        stack.push(1);

        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
