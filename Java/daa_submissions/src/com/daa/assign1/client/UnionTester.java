package com.daa.assign1.client;

import com.daa.assign1.domain.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnionTester {
    public static void main(String[] args) throws IOException {
        UnionInitializer unionInitializer = null;
        boolean menuRunnerMain = true;
        while (menuRunnerMain){
            System.out.println("Select a type Connection Algorithm to use:\n\t1. Quick Find\n\t2. Quick Union\n\t3. Weighted Union\n\t4. Path Compressed Weighted Union\n\t5. Exit");
            System.out.print("Enter input: ");
            int input;
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));
            input = Integer.parseInt(reader.readLine());
            switch (input){
                case 1:
                    unionInitializer = new QuickFind(10);
                    break;
                case 2:
                    unionInitializer = new QuickUnion(10);
                    break;
                case 3:
                    unionInitializer = new WeightedPathCompressedUnion(10);
                    break;
                case 4:
                    unionInitializer = new WeightedUnion(10);
                case 5:
                    menuRunnerMain = false;
                default:
                    input = 0;
            }
            if (input != 0){
                subMenuRunner(unionInitializer);
            }
        }
    }

    private static void subMenuRunner(UnionInitializer unionInitializer) throws IOException {
        boolean menuRunnerSub = true;
        while (menuRunnerSub){
            System.out.println("Select action to use:\n\t1. Union\n\t2. Connected\n\t3. No. of Connected Sets\n\t4. Exit");
            System.out.print("Enter input: ");
            int input;
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));
            input = Integer.parseInt(reader.readLine());
            unionInitializer.displayArr();
            String[] temp;
            switch (input){
                case 1:
                    System.out.println("Enter 2 positions to join(union) separated by space:");
                    temp = reader.readLine().split(" ");
                    unionInitializer.union(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
                    unionInitializer.displayArr();
                    break;
                case 2:
                    System.out.println("Enter 2 positions to check if they are connected separated by space:");
                    temp = reader.readLine().split(" ");
                    System.out.println("Connected: "+unionInitializer.connected(Integer.parseInt(temp[0]),Integer.parseInt(temp[1])));
                    unionInitializer.displayArr();
                    break;
                case 3:
                    System.out.println("Sets: "+unionInitializer.count());
                    unionInitializer.displayArr();
                    break;
                case 4:
                    menuRunnerSub = false;
            }
        }
    }
}
