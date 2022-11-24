package com.ac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class criticaledgesArticulationpoints {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<List<Integer>>connections=new ArrayList<>();
        int connsize=sc.nextInt();
        for (int i = 0; i <connsize ; i++) {
            List<Integer>temp=new ArrayList<>();
            temp.add(sc.nextInt());
            temp.add(sc.nextInt());
            connections.add(temp);
        }
        List<List<Integer>>answer=criticalConnections(n,connections);
        for (List<Integer>i:answer)System.out.println(i);
    }
    static int time=0;
    static List<List<Integer>> criticalConnections(int n,List<List<Integer>>connections){
        if (connections.size()==1)return connections;
        List<List<Integer>>adjlist=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            adjlist.add(new ArrayList<>());
        }
        for (int i = 0; i <connections.size() ; i++) {
            int u=connections.get(i).get(0);
            int v=connections.get(i).get(1);
            adjlist.get(u).add(v);
            adjlist.get(v).add(u);
        }
        int[]visited=new int[n];
        int[]lowtime=new int[n];
        int[]discoverytime=new int[n];
        List<List<Integer>>ans=new ArrayList<>();
        dfs(0,visited,adjlist,lowtime,discoverytime,-1,ans);
        return ans;
    }
    static void dfs(int node,int[]visited,List<List<Integer>>adjlist,int[]lowtime,int[]discoveryrtime,int parent,List<List<Integer>>ans){
     visited[node]=1;
     time++;
     discoveryrtime[node]=time;
     lowtime[node]=time;
     for (int i=0;i<adjlist.get(node).size();i++){
         if (visited[adjlist.get(node).get(i)]==0){
             dfs(adjlist.get(node).get(i),visited,adjlist,lowtime,discoveryrtime,node,ans);
             if (lowtime[adjlist.get(node).get(i)]>discoveryrtime[node]){
                 List<Integer>temp=new ArrayList<>();
                 temp.add(node);
                 temp.add(adjlist.get(node).get(i));
                 ans.add(temp);
             }
             lowtime[node]=Math.min(lowtime[node],lowtime[adjlist.get(node).get(i)]);
         }else if (adjlist.get(node).get(i)!=parent){
             lowtime[node]=Math.min(lowtime[node],discoveryrtime[adjlist.get(node).get(i)]);
         }
     }
    }

}
