package com.ac;

public class balancedparanthesis {
    public static void main(String[] args) {
      print(3,0,0,0,new char[3*2]);
    }
    static void print(int n,int l,int r,int i,char[]st){
        if (i==2*n){
            for (int j = 0; j <st.length ; j++) {
                System.out.print(st[j]+" ");
            }
            System.out.println();
            return;
        }
        if (l==r){
            st[i]='(';
            print(n,l+1,r,i+1,st);
        }else if (l>r){
            if (l==n){
                st[i]=')';
                print(n,l,r+1,i+1,st);
            }else {
                st[i]='(';
                print(n,l+1,r,i+1,st);
                st[i]=')';
                print(n,l,r+1,i+1,st);
            }
        }
    }
}
