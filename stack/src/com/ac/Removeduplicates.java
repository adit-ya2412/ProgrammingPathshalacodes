package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Removeduplicates {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String inputs=(br.readLine().trim());
        System.out.println(removeDuplicateLetters(inputs));
    }
    static String removeDuplicateLetters(String s){
        int[]freq=new int[26];
        int[]present=new int[26];
        for (int i = 0; i <s.length() ; i++) {
            freq[s.charAt(i)-'a']++;
        }
        Stack<Character>sta=new Stack<>();
        sta.push(s.charAt(0));
        freq[s.charAt(0)-'a']--;
        present[s.charAt(0)-'a']=1;
        for (int i = 1; i <s.length(); i++) {
            freq[s.charAt(i) - 'a']--;
            if (present[s.charAt(i) - 'a'] != 1) {
                while (!sta.empty() && (s.charAt(i) < sta.peek() && (freq[sta.peek() - 'a'] > 0))) {
                    present[sta.peek() - 'a'] = 0;
                    sta.pop();

                }
            } else {
                continue;
            }
            sta.push(s.charAt(i));
            present[s.charAt(i) - 'a'] = 1;
        }
        StringBuilder sb = new StringBuilder();
        //pop character from stack and build answer string from back
        while(!sta.isEmpty()){
            sb.insert(0,sta.pop());
        }
        return sb.toString();
//        }
//        String ans="";
////        while (!sta.empty()){
////            ans+=sta.pop();
////        }
//        for (char c:sta) {
//            ans+=c;
//
//        }
//
//     return ans;
    }
    static void reverse(Stack<Character>st){
        if (st.empty())return;
        char x=st.pop();
        reverse(st);
        pushbottom(st,x);
    }
    static void pushbottom(Stack<Character>st,char x){
        if (st.empty()){
            st.push(x);
            return;
        }
        char y=st.pop();
        pushbottom(st,x);
        st.push(y);
    }
}
