package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CustomStringSorting {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String s=(in.readLine().trim());
        String t=(in.readLine().trim());
        String ans=custom(s,t);
        System.out.println(ans);
    }
    static String custom(String s,String t){
        ArrayList<rankpair>list=new ArrayList<>();
        int[]rank=orderrank(s);
        for (int i = 0; i <t.length() ; i++) {
            list.add(new rankpair(t.charAt(i),rank[t.charAt(i)-'a']));
        }
        Collections.sort(list,new sortbyrank());
        String ans="";
        for (rankpair obj:list) {
            ans+=obj.ch;
        }
        return ans;
    }
    static int[]orderrank(String s){
        int[]ans=new int[26];
        for (int i = 0; i <s.length() ; i++) {
            ans[s.charAt(i)-'a']=i+1;
        }
        return ans;
    }

}
class rankpair{
    char ch;
    int rank;
    rankpair(char ch,int rank){
        this.ch=ch;
        this.rank=rank;
    }
}
class  sortbyrank implements Comparator<rankpair>{
    @Override
    public int compare(rankpair ob1,rankpair ob2){
        if (ob1.rank<ob2.rank)return -1;
        else if (ob1.rank==ob2.rank)return 0;
        else return 1;
    }
}
