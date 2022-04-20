package com.ac;

public class MaxvowelsinSubstring {
    public static void main(String[] args) {
        String str="abciiidef";
        System.out.println(max(str,3));
    }
    static int max(String str,int k){
        int maxvow=Integer.MIN_VALUE;
        int vow=0;
        for (int i = 0; i <k ; i++) {
            if (str.charAt(i)=='a'||(str.charAt(i)=='e')||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'){
                vow++;
            }
        }
        if (vow>maxvow)maxvow=vow;
        for (int i = k; i <str.length() ; i++) {
            if (str.charAt(i)=='a'||(str.charAt(i)=='e')||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u')vow++;
            if (str.charAt(i-k)=='a'||(str.charAt(i-k)=='e')||str.charAt(i-k)=='i'||str.charAt(i-k)=='o'||str.charAt(i-k)=='u')vow--;
            if (vow>maxvow)maxvow=vow;
        }
        //if (vow>maxvow)maxvow=vow;
        return maxvow;
    }
}
