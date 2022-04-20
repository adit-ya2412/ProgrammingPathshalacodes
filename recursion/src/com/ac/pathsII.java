package com.ac;

public class pathsII {
    public static void main(String[] args) {
   int[][]arr={{0,0,0},{0,-1,0},{0,0,2}};
   boolean[][]matrix=new boolean[arr.length][arr[0].length];
   int x=0,y=0;
   int c=0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                if (arr[i][j]==1){
                    x=i;
                    y=j;
                    c=1;
                    break;
                }
                if (c!=0)break;
            }
        }

        System.out.println(noofpaths(arr,x,y,matrix));
    }
    static int noofpaths(int[][]arr,int i,int j,boolean[][]maze){
         if (arr[i][j]==2){
             return 1;
         }
         maze[i][j]=true;
         int sum=0;
         if (issafe(arr,i,j+1)&&!(maze[i][j+1])){
             sum+=noofpaths(arr,i,j+1,maze);
         }
         if (issafe(arr,i,j-1)&&!(maze[i][j-1])){
             sum+=noofpaths(arr,i,j-1,maze);
         }
         if (issafe(arr,i-1,j)&&!(maze[i-1][j])){
             sum+=noofpaths(arr,i-1,j,maze);
         }
         if (issafe(arr,i+1,j)&&!(maze[i+1][j])){
             sum+=noofpaths(arr,i+1,j,maze);
         }
         maze[i][j]=false;

         return sum;
    }
    static boolean issafe(int[][]arr,int i,int j){
        if ((i< arr.length&&i>=0 )&& (j<arr[i].length&&j>=0)){
            if (arr[i][j]!=-1){
                return true;
            }
        }
        return false;
    }

}
