package com.ac;

import java.util.ArrayList;
import java.util.List;

public class palindromicpartitioning {
    public static void main(String[] args) {
        List<List<String>>ans=new ArrayList<>();
        String s="nitin";
        String t="";
        partition(s,0,ans,new ArrayList<>());
        System.out.println(ans);

    }
    static void partition(String s, int i, List<List<String>>ans,List<String>temp){
       if (i==s.length()){
           ans.add(new ArrayList<>(temp));
           return;
       }
       String t="";
        for (int j = i; j <s.length() ; j++) {
            t+=s.substring(j,j+1);
            if (palinmdrome(t)){
                temp.add(t);
                partition(s,j+1,ans,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    static boolean palinmdrome(String s){
        char []ch=s.toCharArray();
        for (int i = 0; i < ch.length ; i++) {
            if (ch[i]!=ch[ch.length-1-i]){
                return false;
            }
        }
        return true;
    }
}
