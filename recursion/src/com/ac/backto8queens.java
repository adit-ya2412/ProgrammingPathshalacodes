package com.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class backto8queens {
    public static void main(String[] args) {
     List<List<Integer>>queens=new ArrayList<>();
     int[][]matrix=new int[8][8];
      generate8queens(queens,0,matrix);
        Scanner sc=new Scanner(System.in);
        int[]input=new int[8];
        List<Integer>ans=new ArrayList<>();
        while (sc.hasNext()){
            String[]inputs=sc.nextLine().trim().split("\\s+");
            for (int i = 0; i <8 ; i++) {
                input[i]=Integer.parseInt(inputs[i]);
            }
            ans.add(returnminimummoves(input,queens));
        }
        int m=1;
        for (int i:ans){
            System.out.println("Case "+m+": "+i);
            m++;
        }
    }
    static int returnminimummoves(int[]arr,List<List<Integer>>queens){
        int moves=0;
        int minmoves=Integer.MAX_VALUE;
//        for (int i = 0; i < queens.size() ; i++) {
//            List<Integer>config=queens.get(i);
//            moves=0;

//            for (int j = 0; j < arr.length ; j++) {
//                if(config.get((8*j+(arr[j]-1)))!=1)moves++;
//            }
//            minmoves=Math.min(minmoves,moves);
        for (int i = 0; i <92 ; i++) {
            List<Integer> config = queens.get(i);
            moves=0;
            for (int j = 0; j < arr.length; j++) {
                if (config.get(j) != arr[j]) moves++;
            }
            minmoves=Math.min(minmoves,moves);
        }
        return minmoves;
    }
//    static int[][] makeboard(List<Integer>config) {
//        int[][] ans = new int[8][8];
//        int m = 0, c = 0;
//        for (int i = 0; i < 64; i += 8) {
//            c = 0;
//            for (int j = i; j < i + 8; j++) {
//                ans[m][c] = config.get(j);
//                c++;
//            }
//            m++;
//        }
//        return ans;
//    }
//    static int findone(int[][]config,int colno ){
//            for (int j = 0; j <8; j++) {
//                if (config[j][colno]==1){
//                    return j;
//                }
//            }
//
//        return -1;
//    }
    static void generate8queens(List<List<Integer>>queens,int r,int[][]board){
        if (r==8){
            //List<List<Integer>>qad=new ArrayList<>();
            List<Integer>temp=new ArrayList<>();
            for (int j = 0; j <8 ; j++) {
                for (int i = 0; i <8 ; i++) {
                    if(board[i][j]==1){
                        temp.add(i+1);
                    }
                }
            }
                queens.add(new ArrayList<>(temp));


            return;
        }
        for (int i = 0; i <8 ; i++) {
            if (issafe(board,r,i)){
                board[r][i]=1;
                generate8queens(queens,r+1,board);
                board[r][i]=0;
            }
        }

    }
    static boolean issafe(int[][]q,int i,int j){
        int temp1,temp2;
        temp1=i-1;
        while (temp1>=0){
            if (q[temp1][j]==1)return false;
            temp1--;
        }
        temp1=i-1;temp2=j+1;
        while (temp1>=0&&temp2<8){
            if (q[temp1][temp2]==1)return false;
            temp1--;
            temp2++;
        }
        temp1=i-1;temp2=j-1;
        while (temp1>=0&&temp2>=0){
            if (q[temp1][temp2]==1)return false;
            temp1--;
            temp2--;
        }
        return true;
    }
}
