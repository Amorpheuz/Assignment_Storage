package com.daa.dijkstraImplementation.domain;

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

    public ArrayList<DijkstraData> getDijkstraTable(int sourceNode){
        ArrayList<DijkstraData> dijkstraData = new ArrayList<>();
        ArrayList<Integer> visitedNodes = new ArrayList<Integer>();
        ArrayList<Integer> remainingNodes = new ArrayList<Integer>();
        for (int i = 0; i < vertices; i++) {
            remainingNodes.add(i);
            if(i == sourceNode){
                dijkstraData.add(new DijkstraData(i,0,i));
                continue;
            }
            dijkstraData.add(new DijkstraData(i,Integer.MAX_VALUE,i));
        }
        int tempWeight;
        for (List<Node> Nodes : adjNodes) {
            for (Node node : Nodes){
                tempWeight = node.weight + dijkstraData.get(sourceNode).shortestDist;
                if (tempWeight < dijkstraData.get(node.value).shortestDist){
                    dijkstraData.get(node.value).shortestDist = tempWeight;
                    dijkstraData.get(node.value).prevVertex = sourceNode;
                }
            }
            remainingNodes.remove(new Integer(sourceNode));
            visitedNodes.add(sourceNode);
            sourceNode = getMinNode(dijkstraData,remainingNodes);
        }
        return dijkstraData;
    }

    private int getMinNode(ArrayList<DijkstraData> dijkstraData, ArrayList<Integer> remainingNodes){
        int min = Integer.MAX_VALUE;
        int minDist = Integer.MAX_VALUE;
        for (DijkstraData data:dijkstraData){
            if (remainingNodes.contains(data.vertex)){
                if (data.shortestDist < min){
                    min = data.vertex;
                }
            }
        }
        return min;
    }
}
