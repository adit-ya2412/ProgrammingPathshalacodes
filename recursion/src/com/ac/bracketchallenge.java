package com.ac;

import java.util.Arrays;
import java.util.Scanner;

public class bracketchallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char ch = ' ';
print(n,m,0,0,0,0,0,new char[2*(n+m)]);
        //System.out.println(previousopenbracket(new char[]{'(',')','{','}'}));
    }
     static char previousopenbracket(char[]st,int i){
        char ch=' ';
         for (; i >=0 ; i--) {
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
    static void print(int n ,int m,int l1,int r1,int l2,int r2,int i,char[]st){
     if (i==(2*(n+m))){
         System.out.println(Arrays.toString(st));
         return;
     }
     if (l1==r1 &l1!=n){
         st[i]='(';
         print(n, m, l1+1, r1, l2, r2, i+1, st);
     }
     if (l2==r2&l2!=m){
         st[i]='{';
         print(n, m, l1, r1, l2+1, r2, i+1, st);
     }
     if (l1>r1){
         if (l1==n){
             char ch=previousopenbracket(st,i);
             if (ch=='{'){
                 if (l2!=m){
                     st[i]='}';
                     print(n, m, l1, r1, l2, r2+1, i+1, st);
                     st[i]='{';
                     print(n, m, l1, r1, l2+1, r2, i+1, st);
                 }else {
                     st[i]='}';
                     print(n, m, l1, r1, l2, r2+1, i+1, st);
                 }
             }else {
                 st[i]=')';
                 print(n, m, l1, r1+1, l2, r2, i+1, st);
             }
         }else{
             st[i]='(';
             print(n, m, l1+1, r1, l2, r2, i+1, st);
             if (l2!=m){
                 st[i]='{';
                 print(n, m, l1, r1, l2+1, r2, i+1, st);
             }
         }
     }
     if (l2>r2){
         if (l2==m){
             char ch=previousopenbracket(st,i);
             if (ch=='('){
                 if (l1!=n){
                     st[i]=')';
                     print(n, m, l1, r1+1, l2, r2, i+1, st);
                     st[i]='(';
                     print(n, m, l1+1, r1, l2, r2, i+1, st);
                 }else {
                     st[i]=')';
                     print(n, m, l1, r1+1, l2, r2, i+1, st);
                 }
             }else {
                 st[i]='}';
                 print(n, m, l1, r1, l2, r2+1, i+1, st);
             }
         }else {
             st[i]='{';
             print(n, m, l1, r1, l2+1, r2, i+1, st);
             if (l1!=n){
                 st[i]='(';
                 print(n, m, l1+1, r1, l2, r2, i+1, st);
             }
         }
     }
    }
}



