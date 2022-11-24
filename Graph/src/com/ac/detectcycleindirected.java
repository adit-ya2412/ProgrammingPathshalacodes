package com.ac;

import java.util.ArrayList;
import java.util.Scanner;

public class detectcycleindirected {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int c=0;
        ArrayList<ArrayList<Integer>>adjlist=new ArrayList<>();
        while (c<v){
            adjlist.add(new ArrayList<>());
            c++;
        }
        int edges=sc.nextInt();
        while (edges!=0){
            int u=sc.nextInt();
            int w=sc.nextInt();
            adjlist.get(u).add(w);
            edges--;
        }
        System.out.println(isCyclic(v,adjlist));
    }
    static boolean cycle;
    static boolean isCyclic(int V,ArrayList<ArrayList<Integer>>adj){
        cycle=false;
        int[]visited=new int[V];
        for (int i = 0; i <V ; i++) {
            if (visited[i]==0){
                dfs(i,adj,visited);
            }
        }
        return cycle;
    }
    static void dfs(int node,ArrayList<ArrayList<Integer>>adj,int[]visited){
        if (visited[node]==2)return;
        if (visited[node]==1){
            cycle=true;
            return;
        }
        visited[node]=1;
        for (int i = 0; i <adj.get(node).size() ; i++) {
            dfs(adj.get(node).get(i),adj,visited);
        }
        visited[node]=2;
    }
}
