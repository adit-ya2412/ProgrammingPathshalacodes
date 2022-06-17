package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sortthesquareofelements {
    public static void main(String[] args)throws IOException {
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        String[]elemnts=(in.readLine().trim()).split("\\s+");
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elemnts[i]);
        }
        int[]ans=sortarray(arr);
        System.out.println(Arrays.toString(ans));
    }
    static int[] sortarray(int[]arr){
        int p1=0,p2=0;
        if (arr.length==1)return new int[]{arr[0]*arr[0]};
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i]>=0){
                p1=i;
                p2=i-1;
                break;
            }
        }
        if (p1==0&&arr[arr.length-1]<0){
            for (int i = 0; i < arr.length ; i++) {
                arr[i]=arr[i]*arr[i];
            }
            int i=0,j= arr.length-1;
             while (i<j){
                 int temp=arr[i];
                 arr[i]=arr[j];
                 arr[j]=temp;
                 i++;
                 j--;
             }
             return arr;
        }else if (p1==0){
            for (int i = 0; i < arr.length ; i++) {
                arr[i]=arr[i]*arr[i];
            }
            return arr;
        }

        int k=0;
        int[]ans=new int[arr.length];
        while (p2>=0&&p1< arr.length){
            if (arr[p1]*arr[p1]<=arr[p2]*arr[p2]){
                ans[k]=arr[p1]*arr[p1];
                k++;
                p1++;
            }else {
             ans[k]=arr[p2]*arr[p2];
             k++;
             p2--;
            }
        }
        while (p1< arr.length){
            ans[k]=arr[p1]*arr[p1];
            p1++;
            k++;
        }
        while (p2>=0){
            ans[k]=arr[p2]*arr[p2];
            p2--;
            k++;
        }
        return ans;
    }
}
