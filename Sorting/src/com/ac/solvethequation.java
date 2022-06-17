package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class solvethequation {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]elemnts=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elemnts[i]);
        }
        int noofsixtuples=sixtu(arr);
        System.out.println(noofsixtuples);

    }
    static int sixtu(int[]arr){
        int[]lhs=new int[(int) Math.pow(arr.length, 3)];
        int cnt=0;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length ; j++) {
                for (int k = 0; k < arr.length ; k++) {
                    lhs[cnt]=((arr[i]*arr[j])+arr[k]);
                    cnt++;
                }
            }
        }
        cnt=0;
        int[]rhs=new int[lhs.length];
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length ; j++) {
                for (int k = 0; k < arr.length ; k++) {
                    if (arr[k]!=0){
                        rhs[cnt]=(arr[i]+arr[j])*arr[k];
                        cnt++;
                    }
                }
            }
        }
        Arrays.sort(rhs);
        int noofsixtuples=0;
        for (int i = 0; i < lhs.length ; i++) {
                     int freq=frequency(rhs,lhs[i]);
                     if (freq==0)continue;
                     else noofsixtuples+=freq;

        }
        return noofsixtuples;
    }
    static int frequency(int[]arr,int key){
        int firstooccurenc=findoccurence(arr,key,true);
        int lastoccurence=0;
        if (firstooccurenc!=-1){
         lastoccurence=findoccurence(arr,key,false);}
        if (firstooccurenc==-1)return 0;
        return lastoccurence-firstooccurenc+1;
    }
    static int findoccurence(int[]arr,int key,boolean first){
        int l=0;
        int h= arr.length-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if (arr[mid]>key){
                h=mid-1;
            }else if (arr[mid]<key){
                l=mid+1;
            }else {
                if (first==true){
                    if (mid==0)return mid;
                    else if (arr[mid-1]==key)h=mid-1;
                    else return mid;
                }else {
                    if (mid== arr.length-1)return mid;
                    else if (arr[mid+1]==key)l=mid+1;
                    else return mid;
                }
            }
        }
        return -1;
    }
}
