package com.ac;

import java.util.ArrayList;
import java.util.List;

public class validipadress {
    public static void main(String[] args) {
      List<String>ans=new ArrayList<>();
      String s="25525511135";
      String ip="";
      valid(s,0,0,ans,ip);
        System.out.println(ans);
    }
    static void valid(String s, int i, int dots, List<String>ans,String Ip){
        if (dots==4&&i==s.length()){
            Ip=Ip.substring(0,Ip.length()-1);
            ans.add(Ip);
            return;
        }
        if (dots>4)return;
        for (int j = i; j <Math.min(i+3,s.length()) ; j++) {
            int n=Integer.parseInt(s.substring(i,j+1));
            if (n<256&&(i==j||s.substring(i,j+1).charAt(0)!='0')){
                valid(s,j+1,dots+1,ans,Ip+s.substring(i,j+1)+".");
            }
        }
    }
}
