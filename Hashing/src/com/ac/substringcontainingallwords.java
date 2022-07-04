package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class substringcontainingallwords {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inpu = (br.readLine().trim());
        String[] word = (br.readLine().trim()).split("\\s+");
        System.out.println(startofsubstring(inpu, word));

    }
    static List<Integer>startofsubstring(String s,String[]words){
        List<Integer>ans=new ArrayList<>();
        if (s.length()==0||words.length==0||(words.length*words[0].length()>s.length())){
            return ans;
        }
        HashMap<String,Integer>wordsfreq=new HashMap<>();
        for (int i = 0; i < words.length ; i++) {
            if (wordsfreq.get(words[i])!=null){
                wordsfreq.put(words[i], wordsfreq.get(words[i])+1 );
            }else {
                wordsfreq.put(words[i],1 );
            }
        }
        int n=words.length;
        int l=words[0].length();
        String te;
        int flag;
        HashMap<String,Integer>temp=new HashMap<>();
        for (int i = 0; i <=s.length()-(n*l) ; i++) {
            for (int j = i; j <i+n*l; j+=l) {
                te=s.substring(j,j+l);
                if (temp.get(te)!=null){
                    temp.put(te,temp.get(te)+1);
                }else {
                    temp.put(te,1);
                }

            }
            flag=1;
            for (int j = 0; j <words.length ; j++) {
                if (temp.get(words[j]) == null || (wordsfreq.get(words[j])-temp.get(words[j])!=0)) {
                    flag = 0;
                    break;
                }
            }
                if (flag==1)ans.add(i);
                temp.clear();
            }
       return ans;
    }
}
