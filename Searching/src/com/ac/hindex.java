package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hindex {
    public static void main(String[] args)throws IOException {
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(inp.readLine().trim());
        String[]elements=(inp.readLine().trim()).split("\\s+");
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        System.out.println(indexofscientist(arr));
    }
//    static int indexofscientist(int[]arr){
//        int ans=Integer.MIN_VALUE;
//        for (int i = 0; i <arr.length ; i++) {
//            int elementtorightside=arr.length-1-i;
//            if (elementtorightside<arr[i]){
//                ans=Math.max(ans,elementtorightside+1);
//            }
//        }
//        return ans;
//    }
//static int indexofscientist(int[]arr){
//    int ans=Integer.MIN_VALUE;
//    int l=0;
//    int h=arr.length-1;
//    while (l<=h){
//        int mid=l+(h-l)/2;
//        if (arr.length-1-mid<=arr[mid]){
//            ans=Math.max(ans,(arr.length-1-mid+1));
//            h=mid-1;
//        }else if (arr.length-1-mid>arr[mid]){
//            l=mid+1;
//        }
//    }
//    return ans;
//}
static int indexofscientist(int[]arr) {
    int ans=0;

    int l=0;

    int n = arr.length;

    int h=Math.min(n,arr[arr.length-1]);

    while (l<=h){

        int mid=l+(h-l)/2;

        if(mid==0)

            l=mid+1;

        else if (arr[n-mid]>=mid){

            if(mid==n||arr[n-mid-1]<=mid)

                ans=mid;

            l=mid+1;

        }else {

            h = mid-1;

        }

    }

    return ans;
}


}
