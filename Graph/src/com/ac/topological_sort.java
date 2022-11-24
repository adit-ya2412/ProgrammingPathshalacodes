package com.ac;

import java.util.*;

public class topological_sort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int edges=sc.nextInt();
        int v=sc.nextInt();
        int c=0;
        ArrayList<ArrayList<Integer>>adjlist=new ArrayList<>();
        while (c<v){
            adjlist.add(new ArrayList<>());
            c++;
        }

        while (edges!=0){
            int u=sc.nextInt();
            int w=sc.nextInt();
            adjlist.get(u).add(w);
            edges--;
        }
        System.out.println(Arrays.toString(topoSort(v,adjlist)));
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        int[]indegree=new int[V];
        for(int i=0;i<V;i++){
            for(int j=0;j<adj.get(i).size();j++){
                indegree[adj.get(i).get(j)]++;
            }
        }
        Queue<Integer> qu=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                qu.add(i);
            }
        }
        int[]topological=new int[V];
        int c=0;
        while(!qu.isEmpty()){
            int x=qu.poll();
            topological[c++]=x;
            for(int i=0;i<adj.get(x).size();i++){
                indegree[adj.get(x).get(i)]--;
                if(indegree[adj.get(x).get(i)]==0)qu.add(adj.get(x).get(i));
            }
        }
        return topological;
    }
}
