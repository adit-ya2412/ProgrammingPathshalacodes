package com.ac;

import java.lang.reflect.Array;
import java.util.Arrays;

public class maxconsecutivediff {
    public static void main(String[] args) {
    int[]arr={3,6,9,1};
        //System.out.println(Arrays.toString(findminandmax(arr)));
        System.out.println(maxdifference(arr));
    }
    static int maxdifference(int[]arr){
        int n=arr.length;
        if (n<2)return 0;
        int[]range=findminandmax(arr);
        if (range[0]==range[1])return 0;

        int gap=((range[1]-range[0])/(n-1));
        if ((range[1]-range[0])%(n-1)!=0)gap++;
        int minele=range[0];
        int maxele=range[1];
        int i=0;
        int maxdiff=Integer.MIN_VALUE;
       // int minele=Integer.MAX_VALUE,maxele=Integer.MIN_VALUE;
        int []min=new int[n];
        for (int j = 0; j <n ; j++) {
            min[j]=Integer.MAX_VALUE;
        }
        int[]max=new int[n];
        for (int j = 0; j <n ; j++) {
            max[j]=Integer.MIN_VALUE;
        }

        while (i<n){
            int bucket=((arr[i]-minele)/gap);
            min[bucket]=Math.min(min[bucket],arr[i]);
            max[bucket]=Math.max(max[bucket],arr[i]);
            i++;
            }
        int ans=Integer.MIN_VALUE;
        int prev=Integer.MIN_VALUE;
        for (int j = 0; j <n ; j++) {
            if (min[j]==Integer.MAX_VALUE)continue;
            if (prev==Integer.MIN_VALUE){
                prev=max[j];
            }else {
                ans=Math.max(ans,(min[j])-prev);
                prev=max[j];
            }
        }
        return ans;

        }

    static int[] findminandmax(int[]arr){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }
        return new int[]{min,max};
    }
}
