package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class smallestsubstringwithallcharacters {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String s=(in.readLine().trim());
        String t=(in.readLine().trim());
        smallestsubstring(s,t);
    }
    static String smallestsubstring(String s,String t){
        if (t=="")return "";
        int count=0;
        int[]freqt=new int[256];
        int[]freqs=new int[256];
        for (int i = 0; i <t.length() ; i++) {
            if (freqt[t.charAt(i)]==0){
                count++;
                freqt[t.charAt(i)]++;
            }else {
                freqt[t.charAt(i)]++;
            }
        }
        int r=0,l=0,cnt=0;


        int[]indexofmin=new int[2];
        int temp;
        for (int i = 0; i <s.length() ; i++) {
            freqs[s.charAt(i)]++;
            if (freqs[s.charAt(i)]==freqt[s.charAt(i)])cnt++;
            if (cnt==count){
                r=i;
                break;
            }
        }
        if (cnt<count)return"";
        int anss=l,anse=r;
        int ans=(r-l+1);
        while (r<s.length()){
                while (freqs[s.charAt(l)]>freqt[s.charAt(l)]){
                    freqs[s.charAt(l)]--;
                    l++;
                }
            temp=r-l+1;
            if (temp<ans){
                ans=temp;
                anss=l;
                anse=r;
            }
            r++;
            if (r<s.length())freqs[s.charAt(r)]++;
        }
        System.out.println(s.substring(anss,anse+1));
        return s.substring(anss,(anse+1));
    }
}
