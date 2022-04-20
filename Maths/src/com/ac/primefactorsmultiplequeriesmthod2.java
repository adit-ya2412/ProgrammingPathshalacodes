package com.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class primefactorsmultiplequeriesmthod2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] primes=new int[1001];
        List<Integer>prim=generatesiev(primes);
        int t=sc.nextInt();
        while (t!=0){
            int n=sc.nextInt();
            int num=n;
            for (int i = 0; i <prim.size() ; i++) {
                if (prim.get(i)*prim.get(i)>num)break;
                if (n%prim.get(i)==0){
                    int count =0;
                    while (n%prim.get(i)==0){
                        n=n/prim.get(i);
                        count++;
                    }
                    System.out.println(prim.get(i)+" "+count);
                }
            }
            if (n!=1) System.out.println(n+" "+"1");
            t--;
        }

    }
    static List generatesiev(int[]arr){
        List<Integer>ans=new ArrayList<>();
        for (int i = 2; i <arr.length ; i++) {
            arr[i]=1;
        }
        for (int i = 2; i*i <arr.length ; i++) {
            if (arr[i]==1){
                for (int j = i; j*i <arr.length ; j++) {
                    arr[i*j]=0;
                }
            }
        }
        for (int i = 2; i <arr.length ; i++) {
            if (arr[i]==1)ans.add(i);
        }
        return ans;
    }
}
