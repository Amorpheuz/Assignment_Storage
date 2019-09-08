package com.daa.kruskalImplementation.domain;

import java.util.*;

public class Graph {

    private Edge[] edges;
    private int vertices;

    public Graph(List<Edge> edges, int size) {
        vertices = size;
        this.edges = new Edge[edges.size()];
        this.edges = edges.toArray(this.edges);
        edges.sort(Comparator.comparingInt(o -> o.src));
        printGraph();
    }

    private void printGraph(){
        int temp = edges[0].src;
        for (Edge e : edges){
            if (temp != e.src){
                temp = e.src;
                System.out.println();
            }
            System.out.print(e.src + " --> " + e.dest + " (" + e.weight + ") ");
        }
    }

    public Edge[] getKrusKalMST(){
        Edge[] mstPath = new Edge[vertices];
        int mstIter = 0;
        int sortIter;

        Arrays.sort(edges, Comparator.comparingInt(o -> o.weight));

        for (sortIter = 0; sortIter < vertices; sortIter++)
            mstPath[sortIter] = new Edge();

        WeightedUnion connectedNodes = new WeightedUnion(vertices);
        sortIter = 0;

        while (mstIter < vertices - 1){
            Edge tempEdge;
            tempEdge = edges[sortIter++];

            int rootX = connectedNodes.find(tempEdge.src);
            int rootY = connectedNodes.find(tempEdge.dest);

            if (rootX != rootY){
                mstPath[mstIter++] = tempEdge;
                connectedNodes.union(tempEdge.src,tempEdge.dest);
            }
        }

        return mstPath;
    }
}
