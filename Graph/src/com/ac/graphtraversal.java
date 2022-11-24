package com.ac;

import java.util.*;

public class graphtraversal {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<List<Integer>>adjacencylist=new ArrayList<>(n+1);
        for (int i = 0; i <=n ; i++) {
            List<Integer>temp=new ArrayList<>();
            System.out.println("Enter the elements connected to node "+(i));
            int ele=sc.nextInt();
            for (int j = 0; j <ele ; j++) {
              temp.add(sc.nextInt());
            }
            adjacencylist.add(new ArrayList<>(temp));
        }
        bfs(adjacencylist,new int[n+1]);
    }
    static void bfs(List<List<Integer>>ans,int[]visited){
        for (int i = 1; i <ans.size() ; i++) {
            traverse(i,ans,visited);
        }
    }
    static void traverse(int i,List<List<Integer>>list,int[]visited){
        if (visited[i]==1)return;
        Queue<Integer>queue=new LinkedList<>();
        visited[i]=1;
        queue.add(i);
        while (!queue.isEmpty()){
            int x=queue.poll();
            System.out.println(x);
            for (int j = 0; j <list.get(x).size() ; j++) {
                if (visited[list.get(x).get(j)]==1)continue;
                visited[list.get(x).get(j)]=1;
                queue.add(list.get(x).get(j));
            }
        }
    }
}
