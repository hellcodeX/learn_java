package com.vlad.polymorthism;

public class Test {
    public static void main(String[] args) {
        Object obj = new HumanSubChild();

        HumanBase hb = (HumanBase) obj;

        hb.walk();
    }
}

class HumanBase {
    void walk() {
        System.out.println("BaseHuman walking!");
    }
}

class HumanChild  extends  HumanBase {
    void walk() {
        System.out.println("child walking!");
    }
}

class HumanSubChild extends HumanChild {
    @Override
    void walk() {
        System.out.println("subchild walking!");
    }
}
