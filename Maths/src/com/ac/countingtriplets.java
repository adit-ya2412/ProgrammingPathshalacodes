package com.ac;

import java.util.Scanner;

public class countingtriplets {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int []arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        int []countarray=countfrequency(arr,k);
        System.out.println(numberoftriplets(countarray,k));

    }
    static int[]countfrequency(int[]arr,int k){
        int[]buckets=new int[k];
        for (int i = 0; i <k ; i++) {
            buckets[i]=0;
        }
        for (int i = 0; i < arr.length ; i++) {
            buckets[arr[i]%k]++;
        }
        return buckets;
    }
    static int numberoftriplets(int[]arr,int m){
        //int n=arr.length;
        int ans=0;
        for (int i = 0; i <m ; i++) {
            for (int j = i; j <m ; j++) {
                int k;
                if ((i+j)%m==0)k=0;
                else {
                    k = m - ((i + j) % m);
                }
                    if (k<j)continue;
                    else {
                        if (i==j&&j==k){
                          ans+=(((arr[i])*(arr[i]-1)*(arr[i]-2))/6);
                        }else if (i==j){
                            ans+=(((arr[i])*(arr[i]-1))/2)*arr[k];
                        }else if (i==k){
                            ans+=(((arr[i])*(arr[i]-1))/2)*arr[j];
                        }else if (j==k){
                            ans+=(((arr[j])*(arr[j]-1))/2)*arr[i];
                        }else {
                            ans+=(arr[i])*(arr[j])*(arr[k]);
                        }
                    }
                }
            }
        return ans;
        }
    }

