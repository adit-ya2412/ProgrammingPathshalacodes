package com.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class happystring {
    public static void main(String[] args) {
        List<String>ans=new ArrayList<>();
        char[]ss={'a','b','c'};
        //happycombinations(ss,"",2,0,ans);
        makepermutations(ss,"",1,ans);
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        if (k-1>=ans.size()) System.out.println("");
        else System.out.println(ans.get(k-1));
    }
    static void makepermutations(char[]arr,String temp,int n,List<String>ans){
        for (int i = 0; i <arr.length ; i++) {
            temp+=arr[i];
            happycombinations(arr,temp,n,ans);
            temp=temp.substring(0,temp.length()-1);
        }
    }
    static void happycombinations(char[]arr,String temp, int n,  List<String>ans) {
        if (temp.length() == n) {
            ans.add((temp));
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            if (temp.charAt(temp.length() - 1) != arr[j]) {
                temp += arr[j];
                happycombinations(arr, temp, n, ans);
                temp = temp.substring(0, temp.length() - 1);
            }
        }
    }
}
