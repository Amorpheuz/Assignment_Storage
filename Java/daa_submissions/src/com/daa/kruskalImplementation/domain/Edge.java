package com.daa.kruskalImplementation.domain;

import java.util.Comparator;

public class Edge {
    int src;
    int dest;
    int weight;

    public Edge(){

    }

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int getSrc() {
        return src;
    }

    public int getDest() {
        return dest;
    }

    public int getWeight() {
        return weight;
    }
}
