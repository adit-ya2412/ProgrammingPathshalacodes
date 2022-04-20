package com.ac;

public class PermutationSequence {
    public static void main(String[] args) {

    }
    static int k;
    static void orderperm(int n,int i,String[]arr){
        if (i>n){
            k--;
            return;
        }
        for (int j = i; j <=n ; j++) {

        }
    }
    static String[]shiftright(String[]ch,int i,int j){
         String temp=ch[j];
         String temp1=ch[i],temp2;
        for (int l = i+1; l <=j; l++) {
            temp2=ch[l];
            ch[l]=temp1;
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

}
