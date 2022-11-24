package com.ac;

import java.util.*;

public class closestzero {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][]arr=new int[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                arr[i][j]=sc.nextInt();
            }
        }
        int[][]ans=updateMatrix(arr);
        for(int[]a:ans){
            System.out.println(Arrays.toString(a));
        }
    }
    static int[][] updateMatrix(int[][]mat){
        List<int[]>distances=new ArrayList<>();
        distances.add(new int[]{1,0});
        distances.add(new int[]{-1,0});
        distances.add(new int[]{0,1});
        distances.add(new int[]{0,-1});
        int[][]visited=new int[mat.length][mat[0].length];
        Queue<node>queue=new LinkedList<>();
        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j <mat[i].length ; j++) {
                if (mat[i][j]==0){
                    visited[i][j]=1;
                    queue.add(new node(i,j,0));
                }
            }
        }
        int[][]ans=new int[mat.length][mat[0].length];
        while (!queue.isEmpty()){
            node c=queue.poll();
            ans[c.x][c.y]=c.dist;
            for (int i = 0; i <distances.size() ; i++) {
                node adj=new node(c.x+distances.get(i)[0],c.y+distances.get(i)[1], c.dist+1);
                if (!isvalid(adj.x,adj.y,mat.length,mat[0].length))continue;
                if (visited[adj.x][adj.y]==0){
                    visited[adj.x][adj.y]=1;
                    queue.add(adj);
                }
            }
        }
        return ans;
    }
    static boolean isvalid(int x,int y,int row,int col){
        return x>=0&&x<row&&y>=0&&y<col;
    }
}
