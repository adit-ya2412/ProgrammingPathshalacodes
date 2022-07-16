package com.ac;

import java.util.Stack;

public class queueusingstacks {
    public static void main(String[] args) {
       Myqueue obj=new Myqueue();
       obj.push(10);
       obj.push(2);
       obj.push(-1);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
        System.out.println(obj.pop());
        System.out.println(obj.empty());

    }
}
class Myqueue{
    Stack<Integer>st1=new Stack<>();
    Stack<Integer>st2=new Stack<>();
    int fronts1,bottomofs1;
    public Myqueue(){

    }
    public void push(int x){
     if (st1.empty()&&st2.empty())fronts1=x;
     else if (st1.empty())bottomofs1=x;
     st1.push(x);
    }
    public int pop(){
        if (st2.empty()) {
            while (!st1.empty()) {
                st2.push(st1.pop());
            }
        }
            int ans=st2.pop();
            if (!st2.empty())fronts1=st2.peek();
            else if (!st1.empty())fronts1=bottomofs1;
            return ans;

//      int ans=front;
//      Stack<Integer>s1=new Stack<>();
//      while (!st.empty()){
//          s1.push(st.pop());
//      }
//      st.pop();
//      if (!s1.empty()){
//          front=s1.peek();
//      while (!s1.empty()){
//          st.push(s1.pop());
//      }

    }
    public int peek(){
        return fronts1;
    }
    public boolean empty(){
         return (st1.empty()&&st2.empty());
    }
//    void changefront(Stack<Integer>st){
//        int c=st.pop();
//        if (st.empty()){
//            return;
//        }
//        st.size();
//        st.push(c);
//    }


}
