package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class pushatthebottomofstack {
    public static void main(String[] args)throws IOException {
        Stack<Integer>st=new Stack<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        String[]inputs=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            st.push(Integer.parseInt(inputs[i]));
        }
        int x=Integer.parseInt(br.readLine().trim());
       pushbottom(st,x);
       while (!st.empty()){
           System.out.print(st.pop()+",");
       }
    }
    static void pushbottom(Stack<Integer>st,int x){
        if (st.empty()){
            st.push(x);
            return;
        }
        int top=st.pop();
        pushbottom(st,x);
        st.push(top);
    }
}
