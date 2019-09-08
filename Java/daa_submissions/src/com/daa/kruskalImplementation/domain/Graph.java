package com.daa.kruskalImplementation.domain;

import java.util.*;

public class Graph {

    private Edge[] edges;
    private int vertices;
    private int edges_no;

    public Graph(List<Edge> edges, int size) {
        vertices = size;
        this.edges = new Edge[edges.size()];
        this.edges = edges.toArray(this.edges);
        this.edges_no = this.edges.length;
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.src - o2.src;
            }
        });
        printGraph();
    }

    public void printGraph(){
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
        int mst_iter = 0;
        int sort_iter = 0;

        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        for (sort_iter = 0; sort_iter < vertices; sort_iter++)
            mstPath[sort_iter] = new Edge();

        WeightedUnion connectedNodes = new WeightedUnion(vertices);
        sort_iter = 0;

        while (mst_iter < vertices - 1){
            Edge tempEdge = new Edge();
            tempEdge = edges[sort_iter++];

            int rootX = connectedNodes.find(tempEdge.src);
            int rootY = connectedNodes.find(tempEdge.dest);

            if (rootX != rootY){
                mstPath[mst_iter++] = tempEdge;
                connectedNodes.union(tempEdge.src,tempEdge.dest);
            }
        }

        return mstPath;
    }
}
