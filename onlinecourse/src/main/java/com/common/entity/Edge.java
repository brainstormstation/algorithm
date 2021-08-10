package com.common.entity;

public class Edge {
    public int weight;
    public GraphNode from;
    public GraphNode to;
    public Edge(GraphNode from, GraphNode to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
