package com.ac;

import java.util.*;

public class asfarfromlandaspossible {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][]grid=new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                grid[i][j]=sc.nextInt();
            }
        }
        System.out.println(maxDistance(grid));
    }
    static int maxDistance(int[][]grid){
        Queue<landdistance>queue=new LinkedList<>();
        int [][]visited=new int[grid.length][grid[0].length];
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[i].length ; j++) {
                if (grid[i][j]==1){
                    queue.add(new landdistance(i,j,0));
                    visited[i][j]=1;
                    grid[i][j]=-1;
                }
            }
        }
        List<int[]> directions=new ArrayList<>();
        directions.add(new int[]{1,0});
        directions.add(new int[]{-1,0});
        directions.add(new int[]{0,1});
        directions.add(new int[]{0,-1});

        while (!queue.isEmpty()){
            landdistance adj=queue.poll();
            for (int i = 0; i <directions.size() ; i++) {
                landdistance temp=new landdistance(adj.x+directions.get(i)[0],adj.y+directions.get(i)[1],adj.dist+1);
                if (isvalid(temp.x,temp.y,grid)&&visited[temp.x][temp.y]==0){
                    grid[temp.x][temp.y]=temp.dist;
                    queue.add(temp);
                    visited[temp.x][temp.y]=1;
                }
            }
        }
        int max=Integer.MIN_VALUE;
        int []ans=new int[2];
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid.length ; j++) {
                if (grid[i][j]!=-1){
                    if (grid[i][j]>max){
                        max=grid[i][j];
                    }
                }
            }
        }
        return max;
    }
    static boolean isvalid(int x,int y,int[][]grid){
        return x>=0&&x<grid.length&&y>=0&&y<grid.length&&grid[x][y]!=-1;
    }
}
class landdistance{
    int x;
    int y;
    int dist;
    landdistance(int x,int y,int dist){
        this.x=x;
        this.y=y;
        this.dist=dist;
    }
}
