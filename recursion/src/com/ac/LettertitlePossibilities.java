package com.ac;

import java.util.ArrayList;
import java.util.List;

public class LettertitlePossibilities {
    public static void main(String[] args) {
//        List<Integer>ans=new ArrayList<>();
        String s="AAABBC";
        predict(s.toCharArray(), 0);
        System.out.println(ans);

    }
    static int ans=0;
    static void predict(char[] str, int i ){
        if (i==str.length){
            //ans.add(1);
            return;
        }
        int[]freq=new int[26];
        for (int j = i; j < str.length ; j++) {
            if (freq[str[j]-'A']==0){
                ans++;
                swap(str,i,j);
                predict(str,i+1);
                swap(str,i,j);
            }
                freq[str[j]-'A']++;

        }

    }
    static char[] swap(char[] ch,int i,int sw){

        char temp=ch[i];
        ch[i]=ch[sw];
        ch[sw]=temp;
        return ch;
    }
}
