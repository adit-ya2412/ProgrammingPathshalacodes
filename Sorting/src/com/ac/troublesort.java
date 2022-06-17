package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class troublesort {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(in.readLine().trim());
        int tt=t;
        while (t!=0){
            int n=Integer.parseInt(in.readLine().trim());
            String[]elements=(in.readLine().trim()).split("\\s+");
            long[]arr=new long[n];
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(elements[i]);
            }
            troublesorting(arr);
            boolean flag=true;
            for (int i = 0; i <n-1 ; i++) {
                if(arr[i]>arr[i+1]){
                    System.out.println("Case #"+(tt-t+1)+":"+" "+i);
                    flag=false;
                    break;
                }
            }
            if (flag){
                System.out.println("Case #"+(tt-t+1)+":"+" "+"OK");
            }
            t--;
        }

    }
    static void troublesorting(long []arr){
        List<Long>even=new ArrayList<>();
        List<Long>odd=new ArrayList<>();
        for (int i = 0; i < arr.length ; i++) {
            if (i%2==0){
                even.add(arr[i]);
            }else {
                odd.add(arr[i]);            }
        }
        Collections.sort(even);
        Collections.sort(odd);
        for (int i = 0; i < arr.length ; i++) {
            if (i%2==0){
                arr[i]=even.get(i/2);
            }else {
                arr[i]=odd.get(i/2);
            }
        }

    }
}
