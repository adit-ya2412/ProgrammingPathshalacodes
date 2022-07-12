package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class reversethestack {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        String[]inputs=(br.readLine().trim()).split("\\s+");
        Stack<Integer>st=new Stack<>();
        for (int i = 0; i <n ; i++) {
            st.push(Integer.parseInt(inputs[i]));
        }
        reverse(st);
        while (!st.empty()){
            System.out.print(st.pop());
        }
    }
    static void reverse(Stack<Integer>st){
        if (st.empty())return;
        int x=st.pop();
        reverse(st);
        pushbottom(st,x);
    }
    static void pushbottom(Stack<Integer>st,int x){
        if (st.empty()){
            st.push(x);
            return;
        }
        int y=st.pop();
        pushbottom(st,x);
        st.push(y);
    }
}
