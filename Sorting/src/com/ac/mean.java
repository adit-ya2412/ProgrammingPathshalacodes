package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mean {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        int i=0;
        int count=0;
        boolean flag=true;
        while (flag==true){
            i=0;
            flag=false;
            while (i<n-1){
                if(arr[i]<arr[i+1]){
                    arr[i+1]=0;
                    flag=true;
                }
                i++;
            }
            count++;
        }
        System.out.println(count);
    }
}
