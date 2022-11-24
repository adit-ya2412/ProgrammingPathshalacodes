package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static com.ac.closestzero.isvalid;

public class Shortestpathforking {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String src=(br.readLine().trim());
        String dest=(br.readLine().trim());
        print(src,dest);

    }
    static void print(String src,String dest){
        List<int[]>distances=new ArrayList<>();
        distances.add(new int[]{1,0});//U
        distances.add(new int[]{-1,0});
        distances.add(new int[]{0,1});
        distances.add(new int[]{0,-1});
        distances.add(new int[]{1,1});
        distances.add(new int[]{1,-1});
        distances.add(new int[]{-1,1});
        distances.add(new int[]{-1,-1});
        String[]directions={"U","D","R","L","RU","LU","RD","LD"};

        int[][]visited=new int[8][8];
        int x=src.charAt(1)-'1';
        int y=src.charAt(0)-'a';
        int dist=0;
        visited[x][y]=1;
        int []destinations={dest.charAt(1)-'1',dest.charAt(0)-'a'};
        parentanddirection[][]parents=new parentanddirection[8][8];
        Queue<node>queue=new LinkedList<>();
        parents[x][y]=new parentanddirection(x,y,null);
        queue.add(new node(x,y,0));
        while (!queue.isEmpty()){
            node adj=queue.poll();
            if (adj.x==destinations[0]&&adj.y==destinations[1]){
                dist= adj.dist;
                break;
            }
            for (int i = 0; i <distances.size() ; i++) {
                node c=new node(adj.x+distances.get(i)[0],adj.y+distances.get(i)[1], adj.dist+1 );
                if(!isvalid(c.x,c.y,8,8))continue;
                if (visited[c.x][c.y]==0){
                    visited[c.x][c.y]=1;
                    parents[c.x][c.y]=new parentanddirection(adj.x, adj.y,directions[i]);
                    queue.add(c);
                }
            }
        }
        System.out.println(dist);
        parentanddirection ans=parents[destinations[0]][destinations[1]];
        while (ans.direction!=null){
            System.out.println(ans.direction);
            ans=parents[ans.x][ans.y];
        }
    }
}

class parentanddirection{
    int x;
    int y;
    String direction;
    parentanddirection(int x,int y,String direction){
        this.x=x;
        this.y=y;
        this.direction=direction;
    }
}
