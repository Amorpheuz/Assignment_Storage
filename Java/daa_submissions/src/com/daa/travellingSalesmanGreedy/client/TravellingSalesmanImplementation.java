package com.daa.travellingSalesmanGreedy.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Random;
import static java.lang.Integer.parseInt;

//
//Assumes City numbering starts from 0
//
public class TravellingSalesmanImplementation {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter File Path: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = bufferedReader.readLine();

        System.out.println("Enter number of cities in file: ");
        int cities = parseInt(bufferedReader.readLine());
        String[] lines = null;
        try {
            lines = new String(Files.readAllBytes(Paths.get(filePath))).split("\n");
        }
        catch (NoSuchFileException e){
            System.out.println("Invalid File. Please provide full path to file.");
            System.exit(0);
        }

        int[][] distMatrix = new int[cities][cities];
        String[] temp;
        for (int i = 0; i < cities; i++) {
            distMatrix[i][i] = 0;
        }
        boolean flag = true;
        for (String line : lines){
            if (flag){
                flag = false;
                continue;
            }
            temp = line.split("\t");
            int src = Integer.parseInt(temp[0]);
            int dest = Integer.parseInt(temp[1]);
            int  weight = Integer.parseInt(temp[2]);
            distMatrix[src][dest] = weight;
        }

        Random random = new Random();
        int initCity = random.nextInt(cities);
        int nextCity;
        int visitCount = 1;
        int[] route = new int[cities+1];
        int[] dist = new int[cities+1];
        int[] initCityDistances = new int[cities];
        route[0] = initCity;
        dist[0] = 0;
        for (int i = 0; i < distMatrix.length; i++) {
            initCityDistances[i] = distMatrix[i][initCity];
            distMatrix[i][initCity] = Integer.MAX_VALUE;
        }
        while (true){
            nextCity = findNextCity(distMatrix,initCity);
            dist[visitCount] = distMatrix[initCity][nextCity];
            setCityVisited(distMatrix, nextCity);
            route[visitCount++] = nextCity;
            if (visitCount == cities){
                break;
            }
            initCity = nextCity;
        }
        route[cities] = route[0];
        dist[cities] = initCityDistances[nextCity];
        System.out.println("Route is: ");
        for (int i = 0; i < route.length; i++) {
            int city = route[i];
            if (i ==  route.length - 1) {
                System.out.println(city);
                break;
            }
            System.out.print(city + " -> ");
        }
        System.out.println("Cumulative distances are: ");
        int sum = 0;
        for (int i = 0; i < route.length; i++) {
            sum += dist[i];
            if (i ==  route.length - 1) {
                System.out.println(sum);
                break;
            }
            System.out.print(sum + " -> ");
        }
    }
    
    private static void setCityVisited(int[][] distMatrix, int city){
        for (int i = 0; i < distMatrix.length; i++) {
            distMatrix[i][city] = Integer.MAX_VALUE;
        }
    }

    private static int findNextCity(int[][] distMatrix, int city){
        int minDist = Integer.MAX_VALUE;
        int nextCity = -1;
        for (int i = 0; i < distMatrix.length; i++) {
            if (distMatrix[city][i] < minDist){
                nextCity = i;
                minDist = distMatrix[city][i];
            }
        }
        return nextCity;
    }
}
