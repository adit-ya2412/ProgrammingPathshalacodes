package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class maxconsecutiveones {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int[]arr=new int[n];
        String[]inputs=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(inputs[i]);
        }
        int k=Integer.parseInt(br.readLine().trim());
        System.out.println(longestones(arr,k));

    }
    static int longestones(int[]nums,int k){
        int st=0,end=0;
        int cnt=0;
        int ans=0;
        if (nums.length==1){
            if (nums[0]==0&&k==0)return 0;
            if ((nums[0]==0&&k==1)||nums[0]==1)return 1;
        }
        if (nums[st]==0)cnt++;
        while (end<nums.length-1){
            if (nums[end+1]==0||cnt>k){
                if (cnt+1<=k){
                    cnt++;
                    end++;
                }else {
                    if (nums[st]==0)cnt--;
                    st++;
                }
            }else end++;
            ans=Math.max(ans,(end-st+1));
        }
        return ans;
    }
}
