package com.ac;

public class test1 extends Thread{
    int code=9;
    public void run(){
        this.code=7;
    }

    public static void main(String[] args) {
        test1 thread=new test1();
        thread.start();
        for (int i = 0; i <5 ; i++) {
            System.out.print(thread.code);
        }
    }
}
