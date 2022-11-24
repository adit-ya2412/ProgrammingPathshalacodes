package com.ac;

import java.util.*;

import static com.ac.closestzero.isvalid;

public class rottenoranges {
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
        System.out.println(orangesRotting(arr));
    }
    static int orangesRotting(int[][]grid){
        List<int[]>directions=new ArrayList<>();
        directions.add(new int[]{1,0});
        directions.add(new int[]{-1,0});
        directions.add(new int[]{0,1});
        directions.add(new int[]{0,-1});
        Queue<node>queue=new LinkedList<>();
        //int[][]visited=new int[grid.length][grid[0].length];
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new node(i,j,0));
                }
            }
        }

            int dist=0;
            while (!queue.isEmpty()){
                node adj=queue.poll();
                if (adj.dist>dist)dist=adj.dist;
                for (int i = 0; i <directions.size() ; i++) {
                    if (!isvalid(adj.x+directions.get(i)[0],adj.y+directions.get(i)[1],grid.length,grid[0].length))continue;
                        if (grid[adj.x+directions.get(i)[0]][adj.y+directions.get(i)[1]]!=0) {
                            if (grid[adj.x + directions.get(i)[0]][adj.y + directions.get(i)[1]] ==1) {
                                //visited[xpos + directions.get(i)[0]][ypos + directions.get(i)[1]]=1;
                                grid[adj.x + directions.get(i)[0]][adj.y + directions.get(i)[1]] = 2;
                                queue.add(new node(adj.x +directions.get(i)[0], adj.y+ directions.get(i)[1],adj.dist+1));
                            }
                        }
                }

        }
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[i].length ; j++) {
                if (grid[i][j]==1)return -1;
            }
        }
        return dist;
    }
}
