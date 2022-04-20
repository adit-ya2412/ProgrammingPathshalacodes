package com.ac;

public class uglyprime {
    public static void main(String[] args) {
        System.out.println(check(2147483647));
    }
    static boolean check(int n){
        if (n==1)return true;
        if (n<=0)return false;
        for (int i = 2; i*i <=n ; ) {
            if (i==1000)return false;
            if ((n%i==0)&&(i==2||i==3||i==5)){
                n=n/i;
            }else if((n%i==0)&&(i!=2||i!=3||i!=5)){
                return false;
            }else {
                i++;
            }
        }
        if (n!=0){
            if (n==2||n==3||n==5)return true;
            else return false;
        }
        return false;
    }
}
