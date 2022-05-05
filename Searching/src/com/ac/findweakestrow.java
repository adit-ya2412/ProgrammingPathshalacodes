package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//public class comapare1 implements Comparator<List<List<Integer>>>{
//
//}
public class findweakestrow {
    public static void main(String[] args)throws IOException {
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        String[]size=(inp.readLine().trim()).split("\\s+");
        int n=Integer.parseInt(size[0]);
        int m=Integer.parseInt(size[1]);
        String[][]elements=new String[n][m];
        for (int i = 0; i <n ; i++) {
                elements[i]=(inp.readLine().trim()).split("\\s+");
            }
        int[][]arr=new int[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                arr[i][j]=Integer.parseInt(elements[i][j]);
            }
        }
        List<List<Integer>>ans=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            List<Integer>temp=new ArrayList<>();
            int firstocc=findoccurence(arr[i],1,true);
            int freq;
            if (firstocc!=-1){
                 freq=findoccurence(arr[i],1,false)-findoccurence(arr[i],1,true);

                temp.add(i);
                temp.add(freq+1);
                ans.add(new ArrayList<>(temp));
            }else {
                temp.add(i);
                temp.add(0);
                ans.add(new ArrayList<>(temp));
            }

        }
        Collections.sort(ans, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(1)>o2.get(1)){
                    return 1;
                }
                if (o2.get(1)>o1.get(1))return -1;
                if (o1.get(1)==o2.get(1)){
                    if (o1.get(0)>o2.get(0))return 1;
                    else return -1;
                }
                return 0;
            }
        });
        for (List<Integer>i:ans){
            System.out.print(i.get(0)+" ");
        }
        }

    static int findoccurence(int[]arr,int k,boolean left){
        int l=0;
        int h=arr.length-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if (arr[mid]>k){
                l=mid+1;
            }else if (arr[mid]<k){
                h=mid-1;
            }else {
                if (left==true){
                    if (mid!=0&&arr[mid-1]!=k)return mid;
                    if (mid==0)return mid;
                    h=mid-1;
                }else {
                    if (mid==arr.length-1)return mid;
                    if (arr[mid+1]!=k)return mid;
                    l=mid+1;
                }
            }
        }
        return -1;
    }
}
