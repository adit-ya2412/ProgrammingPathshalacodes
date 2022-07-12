package com.ac;

import java.util.Stack;
public class MinStack {
    public static void main(String[] args) {
     minStack obj=new minStack();
     obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
    }
}
class minStack {
    Stack<Pair>st=new Stack<>();

     minStack() {
       Pair p=new Pair();

    }

    public void push(int val) {
        if(st.empty()){
            st.push(new Pair(val,val));
        }else{
            int min=Math.min(st.peek().y,val);
            st.push(new Pair(val,min));
        }
    }

    public void pop() {
       if (!st.empty()){
           st.pop();
       }
    }

    public int top() {
       if (!st.empty()){
           return st.peek().x;
       }
       return -1;
    }

    public int getMin() {
     if (!st.empty()){
         return st.peek().y;
     }
     return -1;
    }
}
class Pair{
    int x;
    int y;
    Pair(){

    }
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

