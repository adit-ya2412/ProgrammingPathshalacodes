package com.ac;

public class countdistinctpaths {
     static int counts=0;
    public static void main(String[] args) {
        //System.out.println(count(0,0,2,2));
        count2(0,0,3,3);
        System.out.println(counts);
    }
    static int count(int i,int j,int m,int n){
       // if ((i==0||i==m)&&(j==0||j==n))return 1;
//        if (i>m)return 0;
//        if (j>n)return 0;
//        if (i==m&&j==n)return 1;
        if (i==m||j==n)return 1;
        return (count(i,j+1,m,n)+count(i+1,j,m,n));
    }
    static void count2(int i,int j,int m,int n){
        if (i==m||j==n){
            counts++;
            return;
        }
        count2(i,j+1,m,n);
        count2(i+1,j,m,n);

    }
}
