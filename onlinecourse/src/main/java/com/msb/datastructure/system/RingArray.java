package com.msb.datastructure.system;

public class RingArray {
    public static class MyQueue {
        private int[] arr;
        private int size;
        private int pushi;
        private int popi;
        private final int limit;

        public MyQueue(int size) {
            this.limit = size;
            arr = new int[limit];
            pushi = 0;
            popi = 0;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("The queue already be full.");
            }
            size ++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("The queue is empty");
            }

            size--;
            int ans = arr[popi];
            popi = nextIndex(popi);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int nextIndex(int index) {
            return index < limit - 1 ? index +1 : 0;
        }

    } 
}
