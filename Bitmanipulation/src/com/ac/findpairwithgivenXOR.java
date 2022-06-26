package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class findpairwithgivenXOR {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]ele=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(ele[i]);
        }
        int k=Integer.parseInt(in.readLine().trim());
        Arrays.sort(arr);
        int fix,ans;
        int i=0,ind=-1;
        for ( i = 0; i <n ; i++) {
            fix=arr[i];
            ind=binaryseach(arr,i,fix^k);
            if (ind==-1)continue;
            else break;
        }
        if (ind!=-1)System.out.println(arr[i]+" , "+arr[ind]);
    }
    static int binaryseach(int[]arr,int st,int key){
        int l=st,h=arr.length-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if (arr[mid]<key)l=mid+1;
            else if (arr[mid]>key)h=mid-1;
            else return mid;
        }
        return -1;
    }
}
