package com.ac;

import java.util.ArrayList;
import java.util.List;

public class graph {
    List<List<Integer>>adjlist;
    int size;
    graph(int size){
        this.size=size;
        adjlist=new ArrayList<>();
        while (size>0){
            adjlist.add(new ArrayList<>());
            size--;
        }
    }
    void addedge(int first,int second){
        adjlist.get(first).add(second);
        adjlist.get(second).add(first);
    }
}
