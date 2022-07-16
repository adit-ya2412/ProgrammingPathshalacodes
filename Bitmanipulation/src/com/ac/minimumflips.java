package com.ac;

import java.util.Scanner;

public class minimumflips {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int a=sc.nextInt();
       int b=sc.nextInt();
       int c=sc.nextInt();
        System.out.println(minflip(a,b,c));
    }
    static int minflip(int a,int b,int c){
        if ((a|b)==c)return 0;
        int cnt=0;
        int mask=0;
        for (int i = 0; i <31; i++) {
            mask=1<<i;
            if ((c&mask)>0){
                if (((a&mask)==0)&&(b&mask)==0){
                    cnt+=1;
                }
            }else {
                if ((a&mask)>0&&((b&mask)>0)){
                    cnt+=2;
                }else if ((a&mask)>0||(b&mask)>0){
                    cnt+=1;
                }

            }
        }
        return cnt;
    }
}
