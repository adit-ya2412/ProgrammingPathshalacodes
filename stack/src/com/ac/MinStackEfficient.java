package com.ac;

import java.util.Stack;

public class MinStackEfficient {
    public static void main(String[] args) {
     mstack obj=new mstack();
     obj.push(2147483646);
     obj.push(2147483646);
     obj.push(2147483647);
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        obj.push(2147483647);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.push(-2147483648);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());

    }
}
class mstack{
    Stack<Long>st=new Stack<>();
     long curmin;
     mstack(){

     }
     void push(long x){
         if (st.empty()){
             st.push(x);
             curmin=x;
         }else {
             if (x<curmin){
                 long val=2*x-curmin;
                 st.push(val);
                 curmin=x;

             }else st.push(x);
         }
     }
     void pop(){
         if (st.peek()<curmin){
             curmin=2*curmin-st.peek();
             st.pop();
         }else st.pop();
     }
     long top(){
        if (st.peek()<curmin){
            return curmin;
        }else {
           return st.peek();
        }
     }
     long getMin(){
         return curmin;
     }
}
