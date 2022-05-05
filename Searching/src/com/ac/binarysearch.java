package com.ac;

public class binarysearch {
    public static void main(String[] args)
    {
        int[]arr={-2,3,5,6,8,98,100};
        System.out.println(search(arr,8));
    }
    static boolean search(int[]arr,int k){
        int l=0;
        int h=arr.length-1;
        while (l<=h){
            int mid=l+((h-l)/2);
            if (arr[mid]<k){
                l=mid+1;
            }else if (arr[mid]>k){
                h=mid-1;
            }else {
                return true;
            }
        }
        return false;
    }
}
