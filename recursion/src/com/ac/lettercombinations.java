package com.ac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lettercombinations {
    public static void main(String[] args) {

        List<List<Character>>digitmap=new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList('a','b','c')),
                new ArrayList<>(Arrays.asList('d','e','f')),
                new ArrayList<>(Arrays.asList('g','h','i')),
                new ArrayList<>(Arrays.asList('j','k','l')),
                new ArrayList<>(Arrays.asList('m','n','o')),
                new ArrayList<>(Arrays.asList('p','q','r','s')),
                new ArrayList<>(Arrays.asList('t','u','v')),
                new ArrayList<>(Arrays.asList('w','x','y','z'))
        ));
        String digits="";
        if (digits.equals("")) System.out.println(ans);
        letterc("",digits,0,digitmap);
        System.out.println(ans);
    }
     static List<String>ans=new ArrayList<>();
    static void letterc(String temp,String digits,int i,List<List<Character>>digitmap){
       if (i>digits.length()-1){
           ans.add(temp);
           return;
       }
        for (int j = 0; j <digitmap.get(digits.charAt(i)-'2').size() ; j++) {

            letterc(temp+digitmap.get(digits.charAt(i)-'2').get(j),digits,i+1,digitmap);
        }

    }
    static void letterc(char[]temp,String digits,int i,List<List<Character>>digitmap){
        if (i>temp.length-1){
            System.out.println(Arrays.toString(temp));
            return;
        }
        for (int j = 0; j <digitmap.get(digits.charAt(i)-'2').size() ; j++) {
            temp[i]=digitmap.get(digits.charAt(i)-'2').get(j);
            letterc(temp,digits,i+1,digitmap);
        }
    }
}
