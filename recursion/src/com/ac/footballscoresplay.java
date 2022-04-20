package com.ac;

import java.util.Arrays;
import java.util.Scanner;

public class footballscoresplay {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]a=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=sc.nextInt();
        }
        int n1=sc.nextInt();
        int[]b=new int[n1];
        for (int i = 0; i <n1 ; i++) {
            b[i]=sc.nextInt();
        }
        int[]ans=moregoals(a,b);
        for (int i:ans){
            System.out.println(i);
        }
    }
    static int[] moregoals(int[]a,int[]b){
        int[]ans=new int[b.length];
        Arrays.sort(a);
        for (int i = 0; i <b.length ; i++) {
            int st=0;
            int end=a.length-1;
            while (st<=end){
                int mid=st+(end-st)/2;
                if (a[mid]<b[i]){
                    st=mid+1;
                }else if (a[mid]>b[i]){
                    end=mid-1;
                }else {
                    end=mid;
                    break;
                }
            }
            ans[i]=end+1;
        }
        return ans;
    }
}
