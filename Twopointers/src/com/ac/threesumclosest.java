package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class threesumclosest {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String []inputs=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(inputs[i]);
        }
        int target=Integer.parseInt(in.readLine().trim());
        Arrays.sort(arr);
        System.out.println(closest(arr,target));

    }
    static int closest(int[]arr,int targ){
        int ans=Integer.MAX_VALUE;
        int diff=Integer.MAX_VALUE;
        for (int i = 0; i <arr.length-1 ; i++) {
                int l=i+1;
                int h=arr.length-1;
                while (l<h){
                    if (arr[i]+arr[l]+arr[h]==targ)return targ;
                    if (Math.abs(arr[i]+arr[l]+arr[h]-targ)<diff){
                        diff=Math.abs(arr[i]+arr[l]+arr[h]-targ);
                        ans=arr[i]+arr[l]+arr[h];
                    }
                    if ((arr[i]+arr[l]+arr[h])>targ){
                        h--;

                    }else {
                        l++;
                    }
                }
            }
        return ans;
    }
}
