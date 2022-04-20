package com.ac;

public class firstprogram {

    public static void main(String[] args) {
	// write your code here
        int x=0;
        func(x);
        System.out.println(x);
    }
    static void func(int x){
        System.out.println(x);
        if (x>=3)return;
        x++;
        func(x);
        x++;
        func(x);
    }
}
