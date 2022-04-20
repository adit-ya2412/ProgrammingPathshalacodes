package com.ac;

public class LCM {
    public static void main(String[] args) {
        //System.out.println(lcmbruteforce(12,18));
        System.out.println(findtotal(20,2,3,5));
       // System.out.println(lcm1(10,20,60));

    }
    static int lcmbruteforce(int n,int m){
        for (int i =Math.max(n,m); i <n*m ; i++) {
            if (i%n==0&&i%m==0){
                return i;
            }
        }
        return n*m;
    }
    static int findtotal(int n,int a,int b,int c){
        int total=(n/a)+(n/b)+(n/c)-(n/(lcmbyformula(a,b)))-(n/(lcmbyformula(b,c)))-(n/(lcmbyformula(c,a)))+lcm1(a,b,c);
        return total;
    }
    static int lcm1(int a,int b,int c){
       // int hf=gcd(gcd(a,b),c);
        int lc=lcmbyformula(lcmbyformula(a,b),c);
        return lc;
    }
    static int lcmbyformula(int a,int b){
        return (a*b)/gcd(a,b);
    }
    static int gcd(int a,int b){
        int min=Math.min(a,b);
        int max=Math.max(a,b);
        while (min!=0){
            if (max%min==0)return min;
            else {
                int temp=max%min;
                max=min;
                min=temp;
            }
        }
        return 1;
    }
}
