package com.ac;

public class reversebits {
    public static void main(String[] args) {
        System.out.println(rverse(13));
    }
    static int rverse(int n){
        if (n==0)return 0;
        int result=0;
        for (int i = 0; i <32 ; i++) {
            result<<=1;
            if ((n&1)==1)result++;
            n=n>>1;
        }
        return result;
    }
}
