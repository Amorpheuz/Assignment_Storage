package com.daa.quickFind_Union_Weighted.domain;

import java.util.ArrayList;

public class WeightedPathCompressedUnion extends UnionInitializer {
    private int[] treeSize;
    public WeightedPathCompressedUnion(int size){
        super(size);
        treeSize = new int[size];
        for (int i = 0; i < treeSize.length; i++) {
            treeSize[i] = 1;
        }
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(!(rootP==rootQ)){
            if(treeSize[rootP]<treeSize[rootQ]){
                arrToSort[rootP] = rootQ;
                treeSize[rootQ] += treeSize[rootP];
            }
            else {
                arrToSort[rootQ] = rootP;
                treeSize[rootP] += treeSize[rootQ];
            }
            count();
        }
    }

    public int find(int p){
        ArrayList<Integer> temp = new ArrayList<>();
        while (p != arrToSort[p]){
            temp.add(p);
            p = arrToSort[p];
        }
        for (Integer integer : temp) {
            arrToSort[integer] = p;
        }
        return p;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int count(){
        int counter = 0;
        for (int i = 0; i < arrToSort.length; i++) {
            if (arrToSort[i] == i){
                counter++;
            }
        }
        count = counter;
        return counter;
    }

    public void displayArr(){
        System.out.print("Node:\t\t");
        for (int i = 0; i < arrToSort.length; i++) {
            System.out.print(i+" ");
        }
        System.out.print("\nTree Size:\t");
        for (int value : treeSize) {
            System.out.print(value + " ");
        }
        System.out.print("\nConnection:\t");
        for (int value : arrToSort) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
