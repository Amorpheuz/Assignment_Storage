package com.daa.dijkstraImplementation.domain;

public class DijkstraData {
    int vertex;
    int shortestDist;
    int prevVertex;

    public DijkstraData() {
    }

    public DijkstraData(int vertex, int shortestDist, int prevVertex) {
        this.vertex = vertex;
        this.shortestDist = shortestDist;
        this.prevVertex = prevVertex;
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
