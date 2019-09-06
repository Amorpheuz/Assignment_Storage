package com.daa.assign1.domain;

public class WeightedUnion extends UnionInitializer{
    private int[] treeSize;
    public WeightedUnion(int size){
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
        while (p != arrToSort[p]){
            p = arrToSort[p];
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
