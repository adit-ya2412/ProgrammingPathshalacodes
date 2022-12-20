package com.ac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class countnumberofwaystoreachtopusingStaircase {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(countWays(n));
    }
    static int countWays(int n){
        long[]arr=new long[n];
        Arrays.fill(arr,-1);
        dfs(n,arr,0);
        return (int) arr[0];
    }
    static long dfs(int n,long[]arr,int i){
        if (i>n)return 0;
        if (i==n)return 1;
        if (arr[i]!=-1)return arr[i];
        else {
            arr[i]=dfs(n,arr,i+1)+dfs(n,arr,i+2);
        }
        return arr[i];
    }
    static int countre(int n,int stidx){
        if (stidx>n)return 0;
        if (stidx==n)return 1 ;
        return countre(n,stidx+1)+countre(n,stidx+2);
    }
}
