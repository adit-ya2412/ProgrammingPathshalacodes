package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxStack {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=(br.readLine().trim()).split("\\s+");
        List<String>st=new ArrayList<>();
        for (int i = 0; i <str.length ; i++) {
            st.add(str[i]);
        }
      getMax(st);
    }
    public  static List<Integer> getMax(List<String>operations){
        List<Integer>ans=new ArrayList<>();
        Stack<Long>sta=new Stack<>();
        sta.
        String[] t;
        long currmax=0;
        for (int i = 0; i <operations.size() ; i++) {
            t=operations.get(i).trim().split("\\s+");
            if (t.length>1){
                if (sta.empty()){
                    sta.push(Long.parseLong(t[1]));
                    currmax=Long.parseLong(t[1]);
                }else {
                    long x=Long.parseLong(t[1]);
                    if (x>currmax){
                        sta.push(2*x+currmax);
                        currmax=x;
                    }else {
                        sta.push(x);
                    }
                }
            }else {
                int val=Integer.parseInt(t[0]);
                if (val==2){
                    if (sta.peek()>currmax){
                        currmax=sta.peek()-2*currmax;
                        sta.pop();
                    }else sta.pop();
                }else {
                    ans.add((int) currmax);
                }
            }
        }
        return ans;
    }
}

