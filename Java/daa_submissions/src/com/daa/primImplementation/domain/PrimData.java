package com.daa.primImplementation.domain;

public class PrimData {
    int vertex;
    int shortestDist;
    int prevVertex;

    public PrimData() {
    }

    public PrimData(int vertex, int shortestDist, int prevVertex) {
        this.vertex = vertex;
        this.shortestDist = shortestDist;
        this.prevVertex = prevVertex;
    }

    public int getPrevVertex() {
        return prevVertex;
    }

    public int getVertex() {
        return vertex;
    }

    public int getShortestDist() {
        return shortestDist;
    }

    @Override
    public String toString() {
        return "DijkstraData{" +
                "vertex=" + vertex +
                ", shortestDist=" + shortestDist +
                ", prevVertex=" + prevVertex +
                '}';
    }
}
