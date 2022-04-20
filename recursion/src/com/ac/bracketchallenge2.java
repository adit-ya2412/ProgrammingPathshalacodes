package com.ac;

import java.util.Arrays;

public class bracketchallenge2 {
    public static void main(String[] args) {
        char[]st={'(','{','}','(',')'};
        System.out.println(previousopenbracket(st,3));
    }
    static char previousopenbracket(char[]st,int i){
        char ch=' ';
        for ( ; i >=0 ; i--) {
            if (st[i]=='('||st[i]=='{'){
                if (st[i]=='('){
                    if(i==st.length-1||st[i+1]!=')'){
                        return st[i];
                    }
                }
                if (st[i]=='{'){
                    if (i==st.length-1||st[i+1]!='}'){
                        return st[i];
                    }
                }
            }
        }
        return ch;
    }
    static void print(int n,int m,int l1,int r1,int l2,int r2,int i,char[]st){
if (i==(2*(n+m))){
    System.out.println(Arrays.toString(st));
    return;
}
if (l1==r1){
    st[i]='(';
    print(n, m, l1+1, r1, l2, r2, i+1, st);
}else if (l1>r1){
    if (l1==n){
        char ch=previousopenbracket(st,i);
        if (ch=='{'){
            st[i]='}';
            print(n, m, l1, r1, l2, r2+1, i+1, st);
            if (l2!=m){
                st[i]='{';
                print(n, m, l1, r1, l2+1, r2, i+1, st);
            }
        }else {
            st[i]=')';
            print(n, m, l1, r1+1, l2, r2, i+1, st);
        }
    }
}
    }
}
