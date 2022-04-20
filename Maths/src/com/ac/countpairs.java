package com.ac;

import java.util.Scanner;

public class countpairs {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(nofpairs(countarray(arr,k),k));
//        int[]arraycount=countarray(arr,k);
//        for (int i = 0; i <arraycount.length ; i++) {
//            System.out.print(arraycount[i]+" ");
//        }

    }
    static int[]countarray(int[]arr,int k){
        int[] counts=new int[k];
        for (int i = 0; i <k ; i++) {
            counts[i]=0;
        }
        for (int i = 0; i <arr.length ; i++) {
            counts[arr[i]%k]++;
        }
        return counts;
    }
    static int nofpairs(int[]countarray,int k){
        int n=countarray.length;
        int ans=0;
        ans+=((countarray[0]*countarray[0]-1)/2);
        for (int i = 1; i <=(k/2-1) ; i++) {
           ans+=countarray[i]*countarray[k-i];
        }
        if (k%2==0){
            ans+=(countarray[k/2]*(countarray[k/2]-1)/2);
        }else {
            ans+=countarray[k/2]*countarray[k/2+1];
        }
        return ans;
    }
}
