package com.daa.dijkstraImplementation.client;

import com.daa.dijkstraImplementation.domain.DijkstraData;
import com.daa.dijkstraImplementation.domain.Edge;
import com.daa.dijkstraImplementation.domain.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.Integer.parseInt;

public class GraphDijkstraImplementation {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter File Path: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = bufferedReader.readLine();

        System.out.println("Enter source node: ");
        int sourceNode = parseInt(bufferedReader.readLine());
        String[] Lines = null;
        try {
            Lines = new String(Files.readAllBytes(Paths.get(filePath))).split("\n");
        }
        catch (NoSuchFileException e){
            System.out.println("Invalid File. Please provide full path to file.");
            System.exit(0);
        }

        String[] temp;
        Set<Integer> nodes = new LinkedHashSet<>();
        ArrayList<Edge> edges = new ArrayList<>();
        for (int iterator = 0; iterator < Lines.length; iterator++) {
            if (iterator == 0){
                continue;
            }
            temp = Lines[iterator].split("\t");
            int src = Integer.parseInt(temp[0]);
            int dest = Integer.parseInt(temp[1]);
            int  weight = Integer.parseInt(temp[2]);
            edges.add(new Edge(src,dest,weight));
            nodes.add(src);
            nodes.add(dest);
        }
        Graph graph = new Graph(edges,nodes.size());
        ArrayList<DijkstraData> dijkstraData = graph.getDijkstraTable(sourceNode);
        System.out.println("Graph:");
        graph.printGraph();

        boolean loopRunner = true;
        while (loopRunner){
            System.out.print("Select option to perform:\n\t1. Print MST\n\t2. Print Shortest path to a node(weights)\n\t3. Print Shortest path to a node(nodes)\n\t4. Exit\nAnswer: ");
            int option = Integer.parseInt(bufferedReader.readLine());
            int node = Integer.MAX_VALUE;
            switch (option){
                case 1:
                    System.out.println("Minimum Spanning Tree: ");
                    for (DijkstraData data : dijkstraData){
                        System.out.println(data);
                    }
                    break;
                case 2:
                    System.out.print("Enter node: ");
                    node = Integer.parseInt(bufferedReader.readLine());
                    printShortestPath('w',dijkstraData,node);
                    break;
                case 3:
                    System.out.print("Enter node: ");
                    node = Integer.parseInt(bufferedReader.readLine());
                    printShortestPath('n',dijkstraData,node);
                    break;
                case 4:
                    loopRunner = false;
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }

    private static void printShortestPath(char type, ArrayList<DijkstraData> dijkstraData, int node){
        DijkstraData data = dijkstraData.get(node);
        ArrayList<Integer> integers = new ArrayList<>();
        while (data.getPrevVertex() != data.getVertex()){
            switch (type){
                case 'w':
                    integers.add(data.getShortestDist());
                    break;
                case 'n':
                    integers.add(data.getVertex());
            }
            data = dijkstraData.get(data.getPrevVertex());
        }
        switch (type){
            case 'w':
                integers.add(data.getShortestDist());
                break;
            case 'n':
                integers.add(data.getVertex());
        }
        Collections.reverse(integers);
        for (int i : integers){
            if (i == integers.get(integers.size()-1)){
                System.out.println(i);
            }
            else {
                System.out.print(i + " -> ");
            }
        }
    }
}
