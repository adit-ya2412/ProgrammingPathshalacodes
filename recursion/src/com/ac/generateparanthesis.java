package com.ac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class generateparanthesis {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<String>ans=new ArrayList<>();
        char[] st=new char[n*2];
        print(n,0,0,0,st,ans);
        System.out.println(ans);
    }
    static void print(int n, int l, int r,int i, char[]st, List<String>ans){
        if (i==2*n){
            String st1="";
            for (int j = 0; j <st.length ; j++) {
                st1=st1+st[j];
            }
            ans.add(st1);
            return;
        }
        if (l==r){
            st[i]='(';
            print(n,l+1,r,i+1,st,ans);
        }else if (l>r){
            if (l==n){
                st[i]=')';
                print(n,l,r+1,i+1,st,ans);
            }else {
                st[i]='(';
                print(n,l+1,r,i+1,st,ans);
                st[i]=')';
                print(n,l,r+1,i+1,st,ans);
            }
        }
    }
}
