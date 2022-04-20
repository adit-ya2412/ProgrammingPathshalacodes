package com.ac;

public class besttimebuyandsell121 {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(bestime(arr));
    }

    static int bestime(int[] arr) {
        int[]min=premin(arr);
        int profmx=Integer.MIN_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]-min[i]>profmx)profmx=arr[i]-min[i];
        }
        return profmx;
    }
    static int[]premin(int[]arr){
        int[]ans=new int[arr.length];
        ans[0]=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            ans[i]=Math.min(ans[i-1],arr[i]);
        }
        return ans;
    }
}
