package com.daa.kruskalImplementation.domain;

public class Node {
    int value;
    int weight;

    public Node(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public Node() {
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
