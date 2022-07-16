package com.ac;

import java.util.Queue;
import java.util.Stack;

public class reversequeue {
    public static void main(String[] args) {

    }
    void reverseusingstack(Queue<Integer>q){
        Stack<Integer>st=new Stack<>();
        for (int i = 0; i <q.size() ; i++) {
            st.push(q.poll());
        }
        while (!st.empty()){
            q.add(st.pop());
        }
    }
    void reversequebyrecursion(Queue<Integer>q){
        if (q.isEmpty())return;
        int c=q.poll();
        reversequebyrecursion(q);
        q.add(c);
    }
}
