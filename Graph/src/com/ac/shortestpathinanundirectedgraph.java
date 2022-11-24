package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class shortestpathinanundirectedgraph {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine().trim());

        while (t!=0){
            String[]nodesandedges=(br.readLine().trim()).split("\\s+");
            int nodes=Integer.parseInt(nodesandedges[0]);
            int edges=Integer.parseInt(nodesandedges[1]);
            graph g=new graph(nodes+1);
            while (edges>0){
                nodesandedges=(br.readLine().trim()).split("\\s+");
                g.addedge(Integer.parseInt(nodesandedges[0]),Integer.parseInt(nodesandedges[1]));
                edges--;
            }

            int starting=Integer.parseInt(br.readLine().trim());
            int[]dist=bfs(starting,g);
            for(int i=1;i<dist.length;i++){
                if (i==starting)continue;
                if (dist[i]==0) System.out.print(-1+" ");
                else System.out.print(dist[i]*6+" ");
            }
            System.out.println();
            //System.out.println(Arrays.toString(dist));
            t--;
        }
    }
    static int[]bfs(int start,graph g){
        int[]visited=new int[g.size];
        int[]dist=new int[g.size];
        Queue<List<Integer>>queue=new LinkedList<>();
        visited[start]=1;

        List<Integer>temp=new ArrayList<>();
        temp.add(start);
        temp.add(0);
        queue.add(temp);
        while (!queue.isEmpty()){
            temp=queue.poll();
            int x=temp.get(0);
            int d=temp.get(1);
            dist[x]=d;
            for (int i = 0; i <g.adjlist.get(x).size() ; i++) {
                if (visited[g.adjlist.get(x).get(i)]==1)continue;
                visited[g.adjlist.get(x).get(i)]=1;
                temp=new ArrayList<>();
                temp.add(g.adjlist.get(x).get(i));
                temp.add(d+1);
                queue.add(temp);
            }
        }
        return dist;
    }
}
