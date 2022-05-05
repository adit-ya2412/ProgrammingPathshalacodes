package com.ac;

public class findfirstoccurence {
    public static void main(String[] args) {
        int[]arr={1,1,2,2,2,5,6,8,8};
        System.out.println(findfirstoccur(arr,8));
    }
    static int findfirstoccur(int[]arr,int k){
        int l=0;
        int h=arr.length-1;
        while (l<=h){
            int mid=l+((h-l)/2);
            if (arr[mid]<k){
                l=mid+1;
            }else if (arr[mid]>k){
                h=mid-1;
            }else {
                if (mid!=0&&arr[mid-1]!=k)return mid;
                h=mid-1;
            }

        }
        return -1;
    }
}
