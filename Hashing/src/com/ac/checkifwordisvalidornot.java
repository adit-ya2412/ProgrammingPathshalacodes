package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class checkifwordisvalidornot {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String inp=(br.readLine().trim());
        checkifvalid(inp);
    }
    static boolean checkifvalid(String s){

        if (s.length()%3!=0)return false;
        Stack<Character>st=new Stack<>();
        for (int i = 0; i <s.length(); i++) {
          if (s.charAt(i)=='c'){
              if (st.size()>=2&&st.pop()=='b'){
                  if (st.pop()!='a')return false;
              }else return false;
          }else st.push(s.charAt(i));
        }
        if (st.isEmpty())return true;
        else return false;
    }
}
