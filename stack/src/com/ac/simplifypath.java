package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class simplifypath {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String in=(br.readLine().trim());
        System.out.println(simplify(in));

    }
    static String simplify(String path){
        String []pat=path.split("/");
        StringBuilder rs=new StringBuilder();
        Stack<String>st=new Stack<>();
        for (int i = 0; i <pat.length ; i++) {
            if (!st.empty()&&pat[i].equals("..")){
                st.pop();
            }else if ((!pat[i].equals("")&&(!pat[i].equals("."))&&(!pat[i].equals("..")))){
                st.push(pat[i]);
            }
        }
        if (st.isEmpty())return "/";
        while (!st.isEmpty()){
            rs.insert(0,st.pop()).insert(0 , "/");
        }
        return rs.toString();
    }
}
