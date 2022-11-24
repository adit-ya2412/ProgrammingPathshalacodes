package com.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class check_bipartite {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][]graph=new int[n][];
        for (int i = 0; i <n ; i++) {
            int con=sc.nextInt();
            graph[i]=new int[con];
            for (int j = 0; j <con; j++) {
                graph[i][j]=sc.nextInt();
            }
        }
        System.out.println(isBipartite(graph));
    }
    static boolean flag;
    static boolean isBipartite(int[][]graph){
        int[]visited=new int[graph.length];
         flag=true;
        for (int i = 0; i <graph.length ; i++) {
                if (visited[i]==0) {
                    dfs(i,graph,visited,1);
                }
                if (!flag)return flag;
            }

        return flag;
    }
    static void dfs(int node,int[][]graph,int[]visited,int color){
         if (visited[node]!=0){
             if (visited[node]!=color){
                 flag=false;
                 return;
             }
             return;
         }
         visited[node]=color;
        for (int i = 0; i <graph[node].length ; i++) {
            int c = (color == 1 ? 2 : 1);
            dfs(graph[node][i], graph, visited, c);
        }
    }
}
