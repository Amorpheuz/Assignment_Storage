package com.daa.primImplementation.domain;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<List<Node>> adjNodes = new ArrayList<>();
    private int vertices;

    public Graph(List<Edge> edges, int size) {
        vertices = size;
        for (int iterator = 0; iterator <= edges.size(); iterator++) {
            adjNodes.add(iterator, new ArrayList<>());
        }

        for (Edge e : edges) {
            adjNodes.get(e.src).add(new Node(e.dest, e.weight));
        }
    }

    public void printGraph(){
        for (int iterator = 0; iterator < vertices; iterator++) {
            for (Node node : this.adjNodes.get(iterator)) {
                System.out.print(iterator + " --> " + node.value + " (" + node.weight + ") ");
            }
            System.out.println();
        }
    }

    public ArrayList<PrimData> getPrimTable(int sourceNode){
        ArrayList<PrimData> primData = new ArrayList<>();
        ArrayList<Integer> visitedNodes = new ArrayList<Integer>();
        ArrayList<Integer> remainingNodes = new ArrayList<Integer>();

        for (int i = 0; i < vertices; i++) {
            if(i == sourceNode){
                primData.add(new PrimData(i,0,i));
                visitedNodes.add(i);
                continue;
            }
            remainingNodes.add(i);
            primData.add(new PrimData(i,Integer.MAX_VALUE,i));
        }
        while (remainingNodes.size() > 0) {
            int tempMinWeight = Integer.MAX_VALUE;
            int tempMinNode = Integer.MAX_VALUE;
            int tempSrcNode = Integer.MAX_VALUE;
            for (int i : visitedNodes) {
                for (Node node : adjNodes.get(i)){
                    if (remainingNodes.contains(node.value) && node.weight < tempMinWeight){
                        tempMinWeight = node.weight;
                        tempMinNode = node.value;
                        tempSrcNode = i;
                    }
                }
            }
            visitedNodes.add(tempMinNode);
            remainingNodes.remove(new Integer(tempMinNode));
            primData.get(tempMinNode).shortestDist = tempMinWeight;
            primData.get(tempMinNode).prevVertex = tempSrcNode;
        }
        return primData;
    }
}
