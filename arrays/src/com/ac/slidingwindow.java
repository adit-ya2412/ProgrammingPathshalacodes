package com.ac;

public class slidingwindow {
    public static void main(String[] args) {
    // int[]arr={1,2,3,4,5,6,7,8,9,10,11,12};
     //sumofsubarray(arr,3);
        int[]arr={2,2,1,2,4,6,2};
        frequency(arr,4,2);
    }
    static void sumofsubarray(int[]arr,int k){
        int sum=0;
        for (int i = 0; i <=k-1 ; i++) {
            sum+=arr[i];
        }
        for (int i =k; i <arr.length ; i++) {
            System.out.println(sum);
            sum+=arr[i];
            sum-=arr[i-k];

        }
        System.out.println(sum);
    }
    static void frequency(int[]arr,int k,int n){
        int c=0;
        for (int i = 0; i <k ; i++) {
            if (arr[i]==n)c++;
        }
        for (int i =k; i <arr.length ; i++) {
            System.out.println(c);
            if (arr[i]==n)c++;
            if (arr[i-k]==n)c--;
        }
        System.out.println(c);
    }
}
