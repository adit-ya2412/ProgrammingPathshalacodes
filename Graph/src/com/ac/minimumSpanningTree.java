package com.ac;

import java.util.*;

public class minimumSpanningTree {
    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>>adj=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int v=3;
        for (int i = 0; i <v ; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new ArrayList<>(Arrays.asList(new Integer[]{1,5})));
        adj.get(0).add(new ArrayList<>(Arrays.asList(new Integer[]{2,1})));
        adj.get(1).add(new ArrayList<>(Arrays.asList(new Integer[]{2,3})));
        System.out.println(spanningTree(v,adj));
    }
    static int spanningTree(int V,ArrayList<ArrayList<ArrayList<Integer>>>adj){
     ArrayList<ArrayList<Integer>>adjlist=new ArrayList<>();
        for (int i = 0; i <adj.size() ; i++) {
            for (int j = 0; j <adj.get(i).size() ; j++) {
                ArrayList<Integer>temp=adj.get(i).get(j);
                temp.add(0,i);
                adjlist.add(new ArrayList<>(temp));
            }
        }
        Collections.sort(adjlist, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return Integer.compare(o1.get(2),o2.get(2));
            }
        });
        int[]parents=new int[V];
        int[]size=new int[V];
        for (int i = 0; i <V ; i++) {
            parents[i]=i;
            size[i]=1;
        }
        int ans=0;
        for (int i = 0; i <adjlist.size() ; i++) {
            //if (!find(adjlist.get(i).get(0),adjlist.get(i).get(1),parents))continue;
            ans+=union(adjlist.get(i).get(0),adjlist.get(i).get(1),adjlist.get(i).get(2),parents,size);
        }
        return ans;
    }
    static int union(int node1,int node2,int weight,int[]parents,int[]size){

        if (find(node1,node2,parents))return 0;
        int root1=getroot(node1,parents);
        int root2=getroot(node2,parents);
        int size1=size[root1];
        int size2=size[root2];
        if (size1>=size2){
            parents[root2]=root1;
            size[root1]+=size[root2];

        }else{
            parents[root1]=root2;
            size[root2]+=size[root1];
        }
        return weight;
    }
    static boolean find(int node1,int node2,int[]parents){
        return getroot(node1,parents)==getroot(node2,parents);
    }
    static int getroot(int node,int[]parents){
        int i=node;
        while (i!=parents[i]){
            i=parents[i];
        }
        return i;
    }
}
