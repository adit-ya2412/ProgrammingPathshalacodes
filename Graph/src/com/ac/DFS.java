package com.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int node=sc.nextInt();
        int edges=sc.nextInt();
        tempgraph Graph=new tempgraph(node);
        while (edges!=0){
          int u=sc.nextInt();
          int v=sc.nextInt();
          Graph.addedge(u,v);
          edges--;
        }
        System.out.println(countconnected(Graph));
    }
    static int countconnected(tempgraph Graph){
        int[]marked=new int[Graph.size+1];
        int cnt=0;
        for (int i = 1; i <Graph.adjlist.size() ; i++) {
            if (marked[i]==0){
                cnt++;
                dfs(i,Graph.adjlist,marked);
            }
        }
        return cnt;
    }
    static void dfs(int node,List<List<Integer>>list,int[]marked){
        if (marked[node]==1)return;
        marked[node]=1;
        for (int i = 0; i <list.get(node).size() ; i++) {
            dfs(list.get(node).get(i),list,marked);
        }
    }
}
class tempgraph{
    int size;
    List<List<Integer>>adjlist=new ArrayList<>();
    tempgraph(int size){
        this.size=size;
        while (size>=0){
            adjlist.add(new ArrayList<>());
            size--;
        }
    }
    void addedge(int first,int second){
        adjlist.get(first).add(second);
        adjlist.get(second).add(first);
    }
}
