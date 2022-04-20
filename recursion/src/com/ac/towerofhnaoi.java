package com.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class towerofhnaoi {
    public static void main(String[] args) {
        int s=1;
        int h=2;
        int t=3;
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int n=sc.nextInt();
        List<List<Integer>> ans = new ArrayList<>();
        move(s,t,h,ans,r);
        System.out.println(ans.get(n-1));
    }
//    static Scanner sc=new Scanner(System.in);
//    static int i=1;
//    static int targ=sc.nextInt();
    static void move(int s, int t, int h , List<List<Integer>>ans,int n) {
        if (n ==1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(s);
            temp.add(t);
            ans.add(temp);
            return;
        }
            move(s,h,t,ans, n - 1);
        List<Integer> temp = new ArrayList<>();
        temp.add(s);
        temp.add(t);
        ans.add(temp);
        move(h,t,s,ans,n - 1);
        }
    }


