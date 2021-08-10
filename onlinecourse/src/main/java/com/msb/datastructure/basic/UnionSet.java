package com.msb.datastructure.basic;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionSet<V> {
    class Node<V> {
        V value;
        public Node(V value) {
            this.value = value;
        }
    }

    public HashMap<V, Node<V>> nodes;
    public HashMap<Node<V>, Node<V>> parents;
    public HashMap<Node<V>, Integer> sizeMap;

    public UnionSet(List<V> values) {
        for (V v: values) {
            Node<V> node = new Node<>(v);
            nodes.put(v, node);
            parents.put(node,node);
            sizeMap.put(node, 1);
        }
    }

    public boolean isSameSet(V a, V b) {
        if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
            return false;
        }
        return findFather(nodes.get(a)) == findFather(nodes.get(b));
    }

    public Node<V> findFather(Node<V> cur) {
        Stack<Node<V>> stack = new Stack<>();
        while (cur != parents.get(cur)) {
            stack.push(cur);
            cur = parents.get(cur);
        }

        while (!stack.isEmpty()) {
            parents.put(stack.pop(), cur);
        }
        return cur;
     }

     public void union(V a, V b) {
         if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
             return;
         }
         Node<V> ahead = findFather(nodes.get(a));
         Node<V> bhead = findFather(nodes.get(b));
         if (ahead != bhead) {
             int aSize = sizeMap.get(ahead);
             int bSize = sizeMap.get(bhead);
             if (aSize < bSize) {
                 parents.put(ahead, bhead);
                 sizeMap.put(bhead, aSize + bSize);
                 sizeMap.remove(ahead);
             }
             else {
                 parents.put(bhead, ahead);
                 sizeMap.put(ahead, aSize + bSize);
                 sizeMap.remove(bhead);
             }
         }
     }




}

