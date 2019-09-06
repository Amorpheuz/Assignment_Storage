package com.daa.quickFind_Union_Weighted.domain;

public class QuickUnion extends UnionInitializer{
    public QuickUnion(int size){
        super(size);
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(!(rootP==rootQ)){
            arrToSort[rootP] = rootQ;
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
        return find(p)==find(q);
    }

    public int count(){
        int temp = 0;
        for (int i = 0; i < arrToSort.length; i++) {
            if (arrToSort[i] == i){
                temp++;
            }
        }
        count = temp;
        return temp;
    }
}
