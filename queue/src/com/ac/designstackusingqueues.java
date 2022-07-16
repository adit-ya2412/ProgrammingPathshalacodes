package com.ac;

import java.util.LinkedList;
import java.util.Queue;

public class designstackusingqueues {
    public static void main(String[] args) {

    }
}
class stackbyqueue{
    Queue<Integer>qu=new LinkedList<>();
    stackbyqueue(){

    }
    void push(int x){
        qu.add(x);
        for (int i = 1; i <qu.size() ; i++) {
            qu.add(qu.peek());
            qu.remove();
        }
    }
    int pop(int x){
        return qu.remove();
    }
    int top(){
        return qu.peek();
    }
    boolean isempty(){
        return qu.isEmpty();
    }
}
