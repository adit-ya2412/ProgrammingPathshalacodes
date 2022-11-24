package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class knighttour {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        String[]src=(br.readLine().trim()).split("\\s+");
        String[]targ=(br.readLine().trim()).split("\\s+");
        int[]source={Integer.parseInt(src[0]),Integer.parseInt(src[1])};
        int[]destination={Integer.parseInt(targ[0]),Integer.parseInt(targ[1])};
        System.out.println(minStepToReachTarget(source,destination,n));

    }
    static int minStepToReachTarget(int knightpos[],int[]TargetPos,int N){
        List<int[]>directions=new ArrayList<>();
        directions.add(new int[]{2,1});
        directions.add(new int[]{2,-1});
        directions.add(new int[]{-2,1});
        directions.add(new int[]{-2,-1});
        directions.add(new int[]{1,2});
        directions.add(new int[]{1,-2});
        directions.add(new int[]{-1,2});
        directions.add(new int[]{-1,-2});
        knightpos[0]--;
        knightpos[1]--;
        TargetPos[0]--;
        TargetPos[1]--;
        Queue<node>queue=new LinkedList<>();
        int[][]visited=new int[N][N];
        visited[knightpos[0]][knightpos[1]]=1;
        queue.add(new node(knightpos[0],knightpos[1],0));
        while (!queue.isEmpty()){
            node c=queue.poll();
            if (c.x==TargetPos[0]&&c.y==TargetPos[1]){
                return c.dist;
            }
            for (int i = 0; i <directions.size() ; i++) {
                node adj=new node(c.x+directions.get(i)[0],c.y+directions.get(i)[1],c.dist+1);
                if (!isValid(adj.x,adj.y,N))continue;
                if (visited[adj.x][adj.y]==0){
                     visited[adj.x][adj.y]=1;
                     queue.add(adj);
                }
            }
        }
        return -1;

    }
    static boolean isValid(int x,int y,int n){
         return x>=0&&x<n&&y>=0&&y<n;
    }
}
class node{
    int x;
    int y;
    int dist;
    node(int row,int col,int dist){
        this.x=row;
        this.y=col;
        this.dist=dist;
    }
}
