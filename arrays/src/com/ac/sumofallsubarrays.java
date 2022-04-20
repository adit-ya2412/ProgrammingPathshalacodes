package com.ac;

public class sumofallsubarrays {
    public static void main(String[] args) {
     //int[][]arr={{1,1},{1,1}};
       // System.out.println(sum(arr));
        long[]arr={1,2,3};
        System.out.println(sum(arr,3));
    }
    static long sum(long[]arr,long n){
//        int sum=0;
//        for (int i = 0; i <arr.length ; i++) {
//            sum+=(i+1)*(arr.length-i)*arr[i];
//        }
//        return sum;
        long m = 1000000007;

        long sum = 0;

        long ans = 0;

        for(int i=0;i<n;i++){

            sum=((arr[i]%m)*((i+1)%m)*((n-i)%m))%m;

            ans = (ans%m + sum%m)%m;
        }
        return ans;
    }
    static int sum(int[][]arr){
        int sum=0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[0].length ; j++) {
                sum+=(i+1)*(j+1)*(arr.length-i)*(arr[0].length-j)*arr[i][j];
            }

        }
        return sum;
    }
    static long subarraysum(int[][]arr){
        long sum=0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[0].length ; j++) {
                sum+=((i+1)*(j+1)*(arr.length-i)*(arr[0].length-j)*arr[i][j])%(Math.pow(10,9)+7);
            }
        }
        return sum;
    }
}
