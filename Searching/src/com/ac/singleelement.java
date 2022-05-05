package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class singleelement {
    public static void main(String[] args)throws IOException {
      //int[]ar={3,4,4,1,1,7,7,6,6};
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(inp.readLine().trim());
        String[]elements=(inp.readLine().trim()).split("\\s+");
        int []arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        System.out.println(arr[single(arr)]);
    }
    static int single(int[]arr){
        int l=0;
        int h=arr.length-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if (mid!= arr.length-1&&arr[mid]==arr[mid+1]){
                if (mid%2==0)l=mid+1;
                else h=mid-1;
            }else if (mid!=0&&arr[mid]==arr[mid-1]){
                if (mid%2!=0)l=mid+1;
                else h=mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
