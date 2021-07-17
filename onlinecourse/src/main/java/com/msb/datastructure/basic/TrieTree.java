package com.msb.datastructure.basic;

public class TrieTree {
    class Node {
        int pass;
        int end;
        Node[] next = new Node[26];
    }
    private Node root;

    public TrieTree() {
        root = new Node();
    }

    public void insert(String word) {
        if (word == null || word.length() ==0) {
            return;
        }
        Node node = root;
        int index = 0;
        node.pass++;
        for (char c : word.toCharArray()) {
            index = c - 'a';
            if (node.next[index] == null) {
                node.next[index] = new Node();
            }
            node = node.next[index];
            node.pass++;
        }
        node.end++;
    }

    public void delete(String word) {
        if (word == null) {
            return;
        }
        Node node = root;
        int index = 0;
        int count = search(word);
        if (count == 0) {
            return;
        }
        node.pass--;
        for (char c: word.toCharArray()) {
            index = c - 'a';
            if (--node.next[index].pass == 0) {
                node.next[index] = null;
                return;
            }
            node = node.next[index];
        }
        node.end--;
    }

    public int search(String word) {
        if (root == null) {
            return 0;
        }
        Node node = root;
        int index = 0;
        for (char c: word.toCharArray()) {
            index = c - 'a';
            if (node.next[index] == null) {
                return 0;
            }
            node = node.next[index];
        }
        return node.end;
    }

    public int prefixNumber(String pre) {
        if (root == null || pre == null) {
            return 0;
        }
        Node node = root;
        int index = 0;
        for (char c: pre.toCharArray()) {
            index = c - 'a';
            if (node.next[index] == null) {
                return 0;
            }
            node = node.next[index];
        }
        return node.pass;
    }
}
