package com.ac;

public class reversenumber {
    public static void main(String[] args) {
//        reverse(1824);
//        System.out.println(sum);
        System.out.println(rev2(1234));
    }
    static int sum=0;
    static void reverse(int num){
        if (num==0){
            return ;
        }
        int rem=num%10;
        sum=(sum*10)+rem;
        reverse(num/10);
    }
    static int  rev2(int n){
        int digits=(int)(Math.log10(n))+1;
        return help(n,digits);
    }
    static int help(int n,int digits){
        if (n%10==n){
            return n;
        }
        int rem=n%10;
        return (rem*(int)(Math.pow(10,digits-1))+help(n/10,digits-1));

    }
}
