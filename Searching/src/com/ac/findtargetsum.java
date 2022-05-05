package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class findtargetsum {
    public static void main(String[] args)throws IOException {
        BufferedReader ip=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(ip.readLine().trim());
        int[]arr=new int[n];
        String[] elemnts=(ip.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elemnts[i]);
        }
        int targ=Integer.parseInt(ip.readLine().trim());
        int[]ind=findpair(arr,targ);
        System.out.println(ind[0]+" "+ind[1]);
    }
    static int[]findpair(int[]arr,int targ){
        int t,l,h,s=-1;

        int[]ans=new int[2];
        for (int i = 0; i <arr.length-1 ; i++) {
            t=targ-arr[i];
            l=i+1;
            h=arr.length-1;

            while (l<=h){
                int mid=l+(h-l)/2;
                if (arr[mid]<t){
                    l=mid+1;
                }else if (arr[mid]>t){
                    h=mid-1;
                }else {
                   s=mid;
                   break;
                }
            }
            if (s!=-1){
                ans[0]=i+1;
                ans[1]=s+1;
                return ans;
            }
        }
        return ans;
    }
}
