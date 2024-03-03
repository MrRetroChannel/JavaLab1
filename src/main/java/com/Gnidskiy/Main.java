package com.Gnidskiy;

public class Main {
    public static void main(String[] args) {
        Vec<Integer> a = new Vec<> (new Integer[] { 1, 2, 3, 4, 5});

        a.push(10);
        System.out.println(a);
    }
}
