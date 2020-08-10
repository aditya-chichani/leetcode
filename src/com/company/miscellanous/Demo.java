package com.company.miscellanous;

public class Demo {
    int a;
    int b;

    Demo() {

    }

    Demo(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        Demo A = new Demo(10, 20);
        Demo B = new Demo(100, 200);
        Demo tmp = A;
        A = B;
        B = tmp;
        System.out.println(A);
        System.out.println(B);
    }

    @Override
    public String toString() {
        return "Demo{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
