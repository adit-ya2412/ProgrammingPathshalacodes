package com.ac;

public class openclosedoors {
    public static void main(String[] args) {
        System.out.println("The no of open doors are:"+opendoors(5));
    }
    static int counts(int n){
        int s=(int) Math.sqrt(n);
        if (s*s==n)return 1;
        else return 0;
    }
    static int opendoors(int n){
        int open=0;
//        for (int i = 1; i <=n ; i++) {
//            open+=counts(i);
//        }
//        return open;
        open=(int)Math.sqrt(n);
        return open;
    }
}
