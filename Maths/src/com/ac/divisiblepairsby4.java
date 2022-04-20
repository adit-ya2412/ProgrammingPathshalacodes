package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class divisiblepairsby4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t != 0) {
            int size = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[size];
            String[] splits = br.readLine().trim().split("\\s+");
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(splits[i]);
            }
            System.out.println(countpairs(arr));
            t--;
        }
    }
    static int[] frequency(int[]arr){
        int[]freq=new int[4];
        for (int i = 0; i <4 ; i++) {
            freq[i]=0;
        }
        for (int i = 0; i <arr.length ; i++) {
            freq[arr[i]%4]++;
        }
        return freq;
    }
    static long countpairs(int[]arr){
        int[]freq=frequency(arr);
        long sum;
        long zero=freq[0];
        sum=(((zero)*(zero-1))/2);
        long one=freq[1];
        long three=freq[3];
        sum+=one*three;
        zero=freq[2];
        sum+=(((zero)*(zero-1))/2);
        return sum;
    }
}
