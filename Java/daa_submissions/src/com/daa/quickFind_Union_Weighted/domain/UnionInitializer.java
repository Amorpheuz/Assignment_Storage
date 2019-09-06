package com.daa.quickFind_Union_Weighted.domain;

public abstract class UnionInitializer {
    int[] arrToSort;
    int count;

    UnionInitializer(int size){
        arrToSort = new int[size];
        count = size;
        for (int i = 0; i < arrToSort.length; i++) {
            arrToSort[i] = i;
        }
    }

    public abstract void union(int p, int q);
    public abstract int find(int p);
    public abstract boolean connected(int p, int q);
    public abstract int count();
    
    public void displayArr(){
        System.out.print("Node:\t\t");
        for (int i = 0; i < arrToSort.length; i++) {
            System.out.print(i+" ");
        }
        System.out.print("\nConnection:\t");
        for (int value : arrToSort) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
