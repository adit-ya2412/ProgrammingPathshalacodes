package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class happyprime {
    public static void main(String[] args) throws IOException {
      int n=1000000+1;
      long[]count=generatespf(new long[n]);
       // Scanner sc=new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int t=sc.nextInt();
        int t = Integer.parseInt(br.readLine().trim());
        while (t!=0){
            //int num=sc.nextInt();
            int num = Integer.parseInt(br.readLine().trim());
            System.out.println(nofhappyinrange(num,count));
            t--;
        }
    }
    static int nofhappyinrange(int n,long[]count) {
        int noofhappy = (int) count[n];
        return noofhappy;
    }
    static long[] generatespf(long[]primes){
        long[]spff=new long[primes.length];
        for (int i = 2; i <primes.length; i++) {
            primes[i]=1;
            spff[i]=-1;
        }
        for (int i =2; i*i <primes.length ; i++) {
            if (primes[i]==1){
                for (int j = i; j*i <primes.length ; j++) {
                    if (primes[i*j]==1){
                        spff[i*j]=i;
                        primes[i*j]=0;
                    }
                }
            }
        }
        long[]nooffactors=new long[primes.length];
        int n=primes.length;
        for (int i = 2; i <n ; i++) {
            int num=i;
            int count=0;
            long currdivisor=spff[num];
            if (currdivisor!=-1){
                count++;
                num=num/(int) currdivisor;
                while (spff[num]!=-1){
                    if (spff[num]!=currdivisor){
                        count++;
                        currdivisor=spff[num];
                        num=num/(int)currdivisor;
                    }else {
                        num=num/(int)currdivisor;
                    }
                }
                if (num!=0){
                    if (num!=currdivisor){
                        count++;
                    }
                }
            }else count++;
            if (count==2){
                nooffactors[i]=nooffactors[i-1]+1;
            }else{
                nooffactors[i]=nooffactors[i-1];
            }

        }
        return nooffactors;
    }
}
