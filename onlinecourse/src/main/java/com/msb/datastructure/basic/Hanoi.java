package com.msb.datastructure.basic;

public class Hanoi {
    public void hanoi1(int n) {
        leftToRight(n);
    }

    public void hanoi2(int n) {
        func(n, "left", "right", "mid");
    }

    private void func(int n, String from, String to, String other) {
        if (n==1) {
            System.out.println("Move 1 from "+from+" to "+to);
            return;
        }
        func(n-1, from, other, to);
        System.out.println("Move "+n+" from "+from+" to "+to);
        func(n-1, other, to, from);
    }

    private void leftToRight(int n) {
        if (n==1) {
            System.out.println("Move 1 from left to right");
            return;
        }
        leftToMid(n-1);
        System.out.println("Move "+n+" from left to right");
        midToRight(n-1);
    }
    

    private void leftToMid(int n) {
        if (n == 1) {
            System.out.println("Move 1 from left to mid");
            return;
        }

        leftToRight(n-1);
        System.out.println("Move "+n+" from left to mid");
        rightToMid(n-1);
    }

    private void midToRight(int n) {
        if (n==1) {
            System.out.println("Move 1 from mid to right");
            return;
        }
        midToLeft(n-1);
        System.out.println("Move "+n+" from mid to right");
        leftToRight(n-1);
    }

    private void midToLeft(int n) {
        if (n==1) {
            System.out.println("Move 1 from mid to left");
            return;
        }
        midToRight(n-1);
        System.out.println("Move "+n+" from mid to left");
        rightToLeft(n-1);
    }

    private void rightToMid(int n) {
        if (n==1) {
            System.out.println("Move 1 from right to mid");
            return;
        }
        rightToLeft(n-1);
        System.out.println("Move "+n+" from right to mid");
        leftToMid(n-1);
    }

    private void rightToLeft(int n) {
        if (n==1) {
            System.out.println("Move 1 from right to left");
            return;
        }
        rightToMid(n-1);
        System.out.println("Move "+n+" from right to left");
        midToLeft(n-1);
    }
}
