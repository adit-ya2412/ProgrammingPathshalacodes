package com.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class topologicalAlternate {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numcourses=sc.nextInt();
        int[][]prerequisites=new int[numcourses][2];
        for (int i = 0; i <numcourses ; i++) {
            for (int j = 0; j <2 ; j++) {
                prerequisites[i][j]=sc.nextInt();
            }
        }
        System.out.println(topologyusingdfs(numcourses,prerequisites));
    }
    static List<Integer>topologyusingdfs(int numcourses,int[][]prerequisites){
        List<List<Integer>>adjlist=new ArrayList<>();

        for (int i = 0; i <numcourses ; i++) {
        adjlist.add(new ArrayList<>());
        }
        for (int i = 0; i <prerequisites.length ; i++) {
            adjlist.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Stack<Integer>st=new Stack<>();
        int[]visited=new int[numcourses];
        for (int i = 0; i <numcourses ; i++) {
            if (visited[i]==0){
                dfs(i,adjlist,visited,st);
            }
        }
        List<Integer>ans=new ArrayList<>();
        while (!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
    static void dfs(int node,List<List<Integer>>adjlist,int[]visited,Stack<Integer>st){
        if (visited[node]==1)return;
        visited[node]=1;
        for (int i = 0; i <adjlist.get(node).size() ; i++) {
            dfs(adjlist.get(node).get(i),adjlist,visited,st);
        }
        st.push(node);
    }
}
