package com.ac;

import java.io.IOException;
import java.util.Scanner;

public class cummlativebitwiseand {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int l=sc.nextInt();
        int r=sc.nextInt();
        long mask=1;
        long bitmask=mask<<31;
        long ans=0;
        while (bitmask>0) {
            if ((bitmask & l) == (bitmask & r)) {
                if ((bitmask & l) != 0) ans += bitmask;
                bitmask >>= 1;
            } else break;
        }
        System.out.println(ans);
    }
}
