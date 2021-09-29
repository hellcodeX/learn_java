package com.vlad.JCF;

import java.util.Arrays;

public class MyLinkedList {
    /* Существуют 2 вида связанных списков:
     *   - односвязный
     *   - двух связный (можно начать с конца списка)
     * В жава реализован двух связный список. */

    private int size;
    private Node root;

    public void add(int value) {
        if (root == null) {
            this.root = new Node(value);
        } else {
            Node temp = this.root;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        size++;
    }

    public int get(int index) {
        Node temp = this.root;
        int currentIndex = 0;

        while (temp != null) {
            if (currentIndex == index) {
                return temp.getValue();
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        int[] mas = new int[size];

        Node temp = this.root;
        int index = 0;
        // (temp.getNext() != null) неверно так как мы не дойдем до последнего элемента.
        while (temp != null) {
            mas[index++] = temp.getValue();
            temp = temp.getNext();
        }

        return Arrays.toString(mas);
    }

    private static class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}

class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(5);

        System.out.println(myLinkedList.get(2));

        System.out.println(myLinkedList);
    }
}
