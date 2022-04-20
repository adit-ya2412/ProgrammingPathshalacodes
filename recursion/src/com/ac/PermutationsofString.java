package com.ac;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PermutationsofString {
    public static void main(String[] args) {
//
        String[]st={"D","A","B","C"};
        print(st,0);
        //System.out.println(Arrays.toString(rightrotate(st,0,2)));
        //System.out.println(Arrays.toString(leftrotate(st,0,2)));

    }
//    static void print(String []str,int i){ Approach gives without considerring lexicographic order
//        if (i==str.length){
//            System.out.println(Arrays.toString(str));
//            return;
//        }
//        for (int j = i; j <str.length ; j++) {
//                    str = swap(str, i, j);
//                    print(str, i + 1);
//                    str = swap(str, i, j)
//        }
//
//    }
    static String[] swap(String[] ch,int i,int sw){

            String temp=ch[i];
            ch[i]=ch[sw];
            ch[sw]=temp;
            return ch;
    }
    static String[]rightrotate(String[]ch,int i,int j){
        String temp=ch[j];
        String temp1=ch[i],temp2;
        for (int k = i+1; k <=j ; k++) {
            temp2=ch[k];
            ch[k]=temp1;
            temp1=temp2;
        }
        ch[i]=temp;
        return ch;
    }
    static String[]leftrotate(String[]ch,int i,int j) {
        String temp = ch[i];
        String temp1 = ch[j], temp2;
        for (int k = j - 1; k >= i; k--) {
            temp2 = ch[k];
            ch[k] = temp1;
            temp1 = temp2;
        }
        ch[j] = temp;
        return ch;
    }
    static void print(String[]st,int i){
        if (i==st.length){
            System.out.println(Arrays.toString(st));
            return;
        }
        for (int j = i; j <st.length ; j++) {
            st=rightrotate(st,i,j);
            print(st,i+1);
            st=leftrotate(st,i,j);
        }
    }
}
