package com.daa.quickFind_Union_Weighted.domain;

import java.util.HashSet;

public class QuickFind extends UnionInitializer{

    public QuickFind(int size){
        super(size);
    }

    public void union(int p, int q){
        if(!connected(p,q)){
            int tempP = arrToSort[p];
            int tempQ = arrToSort[q];
            for (int i = 0; i < arrToSort.length; i++) {
                if (arrToSort[i] == tempP)
                {
                    arrToSort[i] = tempQ;
                }
            }
            count();
        }
    }

    public int find(int p){
        return arrToSort[p];
    }

    public boolean connected(int p, int q){
        return arrToSort[p] == arrToSort[q];
    }

    public int count(){
        HashSet<Integer> hs = new HashSet<>();
        for (int value : arrToSort) {
            hs.add(value);
        }
        count = hs.size();
        return count;
    }
}
