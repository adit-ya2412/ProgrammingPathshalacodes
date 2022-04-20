package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class countnumberofmultiplequeries {
    public static void main(String[] args) throws IOException {
        int n=1000000+1;
        long[]primes=new long[n];
        long[]spff=generatesieve(primes);
//        Scanner sc=new Scanner(System.in);
        //int t=sc.nextInt()// ;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t!=0){
//            int size=sc1.nextInt();
            int size = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[size];
            String[] splits = br.readLine().trim().split("\\s+");
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(splits[i]);
//            int[]arr=new int[size];
//            for (int i = 0; i <size ; i++) {
//                arr[i]= sc.nextInt();
            }
            printingprimefactors(arr,spff);
            t--;

        }
    }
    static void printingprimefactors(int[]arr,long[]spff){
        for (int i = 0; i <arr.length ; i++) {
            int num=arr[i];
            long count=0;
            long currdivisor=spff[num];
            if (currdivisor!=-1){
                count++;
                num=num/(int)currdivisor;
                while (spff[num]!=-1){
                    if (spff[num]!=currdivisor){
                        count++;
                        currdivisor=spff[num];
                        num=num/(int)currdivisor;
                    }else num=num/(int) currdivisor;
                }
                if (num!=0){
                    if (num!=currdivisor){
                        count++;
                        System.out.print(count+" ");
                    }else {
                        System.out.print(count+" ");
                    }
                }
            }else {
                System.out.print(1+" ");
            }
        }
    }
    static long[] generatesieve(long[]primes){
        long[]spff=new long[primes.length];
        for (int i = 2; i <primes.length ; i++) {
            primes[i]=1;
            spff[i]=-1;
        }
        for (int i = 2; i*i <primes.length ; i++) {
            if (primes[i]==1){
                for (int j = i; j*i <primes.length ; j++) {
                    if (primes[i*j]==1){
                        spff[i*j]=i;
                        primes[i*j]=0;
                    }
                }
            }
        }
        return spff;
    }
}
