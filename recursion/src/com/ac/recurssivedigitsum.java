package com.ac;

public class recurssivedigitsum {
    public static void main(String[] args)  {
        String st="123";
        int k=3;
        System.out.println(superdigit(st,k));
    }
    static int superdigit(String n,int k){
          String st="";
        long x=0;
        for (int i = 0; i <n.length() ; i++) {
            x+=(n.charAt(i)-48);
        }
        x=x*k;
          st+=x;
        n=st;

        return superd(n);
    }
    static int  superd(String n){
        String str="";
        long y=0;
        for (int i = 0; i <n.length() ; i++) {
            char ch=n.charAt(i);
                y+=(ch-48);

            }
        str+=y;
        n=str;
        if (n.length()==1){
            long x=n.charAt(0)-48;
            return (int) x;
        }else {
            return superd(n);
        }
    }
}
