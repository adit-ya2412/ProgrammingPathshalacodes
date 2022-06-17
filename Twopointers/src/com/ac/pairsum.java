package com.ac;

import java.util.Arrays;
import java.util.Scanner;

public class pairsum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        System.out.println(Arrays.toString(countpairsum(arr,target)));
    }
    static int[] countpairsum(int[]arr,int targ){

        int l=0;
        int h=arr.length-1;
        while (l<=h){
            if (arr[l]+arr[h]>targ){
                h--;
            }else if (arr[l]+arr[h]<targ){
                l++;
            }else {
               return new int[]{arr[l],arr[h]};
            }
        }
        return new int[]{-1,-1};
    }

}
