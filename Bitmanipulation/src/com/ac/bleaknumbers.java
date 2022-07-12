package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bleaknumbers {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        System.out.println(is_bleak(n));

    }
    static int is_bleak(int n){
        int l=0;
        int h=n-1;
        while (l<h){
            int mid=l+(h-l)/2;
            if (mid+count_setbits(mid)==n)return 0;
            else if (mid+count_setbits((mid))>n){
                h=mid;
            }else {
                l=mid;
            }
        }
        return 1;
    }
    static int isbleak(int n){
        if (n==1)return 1;
        for (int i = 0; i <n ; i++) {
            if (i+count_setbits(i)==n)return 0;
        }
        return 1;
    }
    static int count_setbits(int n){
        int ans=1;
        while ((n&n-1)!=0){
            ans++;
            n=n&n-1;
        }
        return ans;
    }
}
