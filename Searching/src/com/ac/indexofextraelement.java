package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class indexofextraelement {
    public static void main(String[] args)throws IOException {
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(inp.readLine().trim());
        String[]elements1=(inp.readLine().trim()).split("\\s+");
        String[]elements2=(inp.readLine().trim()).split("\\s+");
        int[]arr1=new int[n];
        int[]arr2=new int[n-1];
        for (int i = 0; i <n ; i++) {
            arr1[i]=Integer.parseInt(elements1[i]);
            if (i!=n-1){
                arr2[i]=Integer.parseInt(elements2[i]);
            }

        }
        System.out.println(findextra(arr1,arr2,n));
    }
    static int findextra(int[]arr1,int[]arr2,int n){
        int l=0;
        int h=n-2;
        while (l<=h){
            int mid=l+(h-l)/2;
            if (arr1[mid]==arr2[mid]){
                l=mid+1;
            }else {
                h=mid-1;
            }
        }
        return l;
    }
}
