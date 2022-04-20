package com.ac;

import java.util.Scanner;

public class alyonaflower740b {
    public static void main(String[] args) {
       maxselection();
    }
    static void maxselection(){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sn=sc.nextInt();
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        int []premax=pmx(arr);
        int sum;
        int total=0;
        while (sn!=0){
            int l=sc.nextInt();
            int r=sc.nextInt();
            l=l-1;
            r=r-1;
            if (l==0)sum=premax[r];
            else {
                sum=premax[r]-premax[l-1];
            }
            if (sum>0)total+=sum;
          sn--;
        }
        System.out.println(total);
    }
    static int[]pmx(int[]arr){
        int[]ans=new int[arr.length];
        ans[0]=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            ans[i]=ans[i-1]+arr[i];
        }
        return ans;
    }
}
