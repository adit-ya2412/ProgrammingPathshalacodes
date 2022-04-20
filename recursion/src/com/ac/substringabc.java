package com.ac;

import java.util.ArrayList;

public class substringabc {
    public static void main(String[] args) {
       String str="abc";
        System.out.println(substringlist(str,""));
    }
    static void substring(String s,String ans){
        if (s.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch=s.charAt(0);
        substring(s.substring(1),ans+ch);
        substring(s.substring(1),ans);

    }
    static ArrayList<String> substringlist(String s,String ans){
        if (s.isEmpty()){
            ArrayList<String>ls=new ArrayList<>();
            ls.add(ans);
            return ls;
        }
        char ch=s.charAt(0);
        ArrayList<String>left=substringlist(s.substring(1),ans+ch);
        ArrayList<String>right=substringlist(s.substring(1),ans);
        left.addAll(right);
        return left;
    }
}
