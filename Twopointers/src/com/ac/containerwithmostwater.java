package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class containerwithmostwater {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int[]arr=new int[n];
        String[]ele=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(ele[i]);
        }
        System.out.println(maxArea(arr));

    }
    static int maxArea(int[]height){
        int l=0;
        int h=height.length-1;
        int ans=Integer.MIN_VALUE;
        int min;
        while (l<=h){
            min=Math.min(height[l],height[h]);
            if (min==height[l]){
                ans=Math.max(ans,min*(h-l));
                l=l+1;
            }else {
                ans=Math.max(ans,min*(h-l));
                h=h-1;
            }
        }
        return ans;
    }
}
