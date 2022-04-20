package com.ac;

import java.util.Scanner;

public class skipacharacter {
    public static void main(String[] args) {
        String s="Adityaeatsanapplcda";
//        String ans="";
//        removecharacter(s,ans,0,'a');
//        System.out.println(ans);
        removestringbutwithcondition(s,"");
    }
    static void removecharacter(String str,String ans,int i,char targ){
        if (i==str.length()){
            System.out.println(ans);
            return;
        }
        if (str.charAt(i)==targ){
            removecharacter(str,ans,i+1,targ);
        }else {
            char ch=str.charAt(i);
            ans=ans+ch;
            removecharacter(str,ans,i+1,targ);
        }
    }
    static void removestring(String str,String ans){
        if (str.isEmpty()){
            System.out.println(ans);
            return;
        }
        if (str.startsWith("Apple")){
            removestring(str.substring(5),ans);
        }else {
            ans=ans+str.charAt(0);
            removestring(str.substring(1),ans);
        }
    }
    static void removestringbutwithcondition(String str,String ans){
        if (str.isEmpty()){
            System.out.println(ans);
            return;
        }
        if (str.startsWith("app")&&!str.startsWith("apple")){
            removestringbutwithcondition(str.substring(3),ans);
        }else {
            ans=ans+str.charAt(0);
            removestringbutwithcondition(str.substring(1),ans);
        }
    }
}
