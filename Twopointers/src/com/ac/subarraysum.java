package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class subarraysum {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String[]inpu=(in.readLine().trim()).split("\\s+");
        int n=(Integer.parseInt(inpu[0]));
        int[]arr=new int[n];
        String[]elements=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        int sum=Integer.parseInt(inpu[1]);
        System.out.println(subarrayexists(arr,sum));

    }
    static ArrayList<Integer> subarrayexists(int[]arr, int sum){
        ArrayList<Integer>ans=new ArrayList<>();
        int i=0,j=0;
        int curr=arr[i];
        while (j< arr.length){
            if (curr<sum){
                j++;
                if (j< arr.length)curr+=arr[j];
            }else if (curr>sum){
                curr-=arr[i];
                i++;
                if (i>j){
                    j++;
                    if (j< arr.length)curr+=arr[j];
                }

            }else {
                ans.add(i+1);
                ans.add(j+1);
                return ans;
            }
        }
        ans.add(-1);
        return ans;
    }
}
