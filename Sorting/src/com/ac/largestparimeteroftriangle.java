package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class largestparimeteroftriangle {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int[]arr=new int[n];
        String[]elements=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        System.out.println(perimeter(arr));

    }
    static int perimeter(int[]arr){
        Arrays.sort(arr);
        if (arr.length==3){
            if (arr[2]<arr[1]+arr[0]){
                return arr[2]+arr[1]+arr[0];
            }else return 0;
        }
        int sum=0;
        for (int i = arr.length-1; i >=2; i--) {
            if (arr[i]<arr[i-1]+arr[i-2]){
                sum=arr[i]+arr[i-1]+arr[i-2];
                break;
            }
        }
        return sum;
    }
}
