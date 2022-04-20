package com.ac;

import java.util.ArrayList;
import java.util.List;

public class countbits {
    public static void main(String[] args) {
        System.out.println(countBits1(2));
    }
    static int[] countBits1(int n) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<=n;i++){
            int sum=0;
            int num=i;
            while(num!=0){
                sum+=num%2;
                num=num/2;
            }
            ans.add(sum);
        }
        int[]arr=new int[n+1];
        for(int i=0;i<n+1;i++){
            arr[i]=ans.get(i);
        }
        return arr;
    }
}
