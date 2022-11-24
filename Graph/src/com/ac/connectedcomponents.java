package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class connectedcomponents {
    static int count;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine().trim());
        int size;
        int edges;
         List<Integer>sieve=createsieve(2000005);
        while (t!=0){
            String[]inputs=(br.readLine().trim()).split("\\s+");
            size=Integer.parseInt(inputs[0]);
            edges=Integer.parseInt(inputs[1]);
            tempgraph2 gr=new tempgraph2(size);
            while (edges!=0){
             inputs=(br.readLine().trim()).split("\\s+");
             int m=Integer.parseInt(inputs[0]);
             int n=Integer.parseInt(inputs[1]);
             gr.addedge(m,n);
             edges--;
            }
            int[]visited=new int[gr.size+1];
            int maxcount=1;
            for (int i = 1; i <=gr.size ; i++) {
                if (visited[i]==0){
                    count=0;
                    dfs(i,gr,visited);
                    maxcount=Math.max(maxcount,count);
                }
            }
           if (maxcount==1){
               System.out.println(-1);

           }else {
               System.out.println(sieve.get(maxcount));
           }
            t--;
        }

    }
    static void dfs(int node,tempgraph2 gr,int[]visited){
        if (visited[node]==1){
            return;
        }

        visited[node]=1;
        count++;
        for (int i = 0; i <gr.adjlist.get(node).size() ; i++) {
         dfs(gr.adjlist.get(node).get(i),gr,visited);
        }
    }
    static List<Integer>createsieve(int range){
        int[]sieve=new int[range+1];
        for (int i = 2; i*i <=range ; i++) {
            if (sieve[i]==0){
                for (int j = 2; j*i <=range ; j++) {
                    sieve[i*j]=-1;
                }
            }
        }
        List<Integer>ans=new ArrayList<>();
        for (int i = 1; i <sieve.length ; i++) {
            if (sieve[i]==0)ans.add(i);
        }
        return ans;
    }
}

class tempgraph2{
    int size;
    List<List<Integer>>adjlist=new ArrayList<>();
    tempgraph2(int size){
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
