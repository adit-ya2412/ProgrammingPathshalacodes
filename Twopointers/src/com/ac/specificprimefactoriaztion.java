package com.ac;

import java.util.Scanner;

public class specificprimefactoriaztion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int n3=sc.nextInt();
        int n=sc.nextInt();
        System.out.println(nthnatural(n1,n2,n3,n));
    }
    static int nthnatural(int n1,int n2,int n3,int n){
        int[]temp=new int[n];
        int i=0,j=0,k=0;
        temp[0]=1;
        int min,val;
        for (int t = 1; t <n ; t++) {
            val=Math.min(Math.min(temp[i]*n1,temp[j]*n2),temp[k]*n3);
            temp[t]=val;
            if(val==temp[i]*n1)i++;
            if (val==temp[j]*n2)j++;
            if (val==temp[k]*n3)k++;

        }
        return temp[n-1];
    }
}
