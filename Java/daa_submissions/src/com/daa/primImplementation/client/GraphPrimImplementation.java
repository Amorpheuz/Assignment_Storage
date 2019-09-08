package com.daa.primImplementation.client;

import com.daa.primImplementation.domain.Edge;
import com.daa.primImplementation.domain.Graph;
import com.daa.primImplementation.domain.PrimData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import static java.lang.Integer.parseInt;

public class GraphPrimImplementation {
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

        System.out.println("Graph:");
        graph.printGraph();
        ArrayList<PrimData> primData = graph.getPrimTable(sourceNode);
        for (PrimData data : primData){
            System.out.println(data);
        }
    }
}
