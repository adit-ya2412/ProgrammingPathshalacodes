package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=(br.readLine().trim());
        System.out.println(valid(s));
    }
    static boolean valid(String st){
        Stack<Character>sta=new Stack<>();
        for (int i = 0; i <st.length() ; i++) {
            if (st.charAt(i)=='('||st.charAt(i)=='['||st.charAt(i)=='{'){
                sta.push(st.charAt(i));
            }else {
                if (sta.empty())return false;
                char c=sta.pop();
                if (!((st.charAt(i)==')'&&c=='(')||(st.charAt(i)==']'&&c=='[')||(st.charAt(i)=='}'&&c=='{'))){
                    return false;
                }
            }

        }
        if (sta.empty())return true;
        return false;
    }

}
