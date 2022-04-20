package com.ac;

public class maxnoofsinrow {
    public static void main(String[] args) {
       //int[][]arr={{0,1,1,1},{0,0,1,1},{1,1,1,1},{0,0,0,0}};
        int[][]arr={{0,0},{0,1}};
        System.out.println(maxrow(arr));
    }
    static int maxrow(int[][]arr){
        int rowst=0;
        int colst=arr[0].length-1;
        int maxrow=0;
        while (rowst<arr.length&&colst>=0){
            if (arr[rowst][colst]==1){
                colst--;
                maxrow=rowst;
            }else if (arr[rowst][colst]!=1){
                rowst++;
            }
        }
        return maxrow;
    }
}
