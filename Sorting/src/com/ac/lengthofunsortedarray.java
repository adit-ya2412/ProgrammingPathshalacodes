package com.ac;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class lengthofunsortedarray {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]ele=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(ele[i]);
        }
        System.out.println(Arrays.toString(printUnsorted(arr,n)));

    }
    static int[]printUnsorted(int[]arr,int n){
        if (n==1)return new int[]{0,0};
        int s=Integer.MAX_VALUE;
        int g=Integer.MIN_VALUE;
        int i=0,j=n-1;
        while (i<n-1&&arr[i]<=arr[i+1]){
            i++;
        }
        while (j>0&&arr[j-1]<=arr[j])j--;
        for (int k = i; k <=j ; k++) {
            s=Math.min(s,arr[k]);
            g=Math.max(g,arr[k]);
        }
        int[]ans=new int[2];
        for (int k = 0; k <=i ; k++) {
            if (arr[k]>s){
                ans[0]=k;
                break;
            }
        }
        for (int k = n-1; k >=j ; k--) {
            if (arr[k]<g){
                ans[1]=k;
                break;
            }
        }
      return ans;
    }
}
