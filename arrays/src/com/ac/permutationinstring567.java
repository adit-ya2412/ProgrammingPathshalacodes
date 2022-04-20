package com.ac;

public class permutationinstring567 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(anagram(s1, s2));
    }
    static boolean check(int[]arr1,int[] arr2){
        for (int i = 0; i <26; i++) {
            if (arr1[i]!=arr2[i])return false;
        }
        return true;
    }

    static boolean anagram(String s1, String s2) {

     int n=s1.length();
     int m=s2.length();
     if (m<n)return false;
        int[] freq1 = new int[30];//maintaining f1 string
        int[] freq2 = new int[30];//maintaing f2 string
        for (int i = 0; i <26 ; i++) {
            freq1[i]=freq2[i]=0;//cleaning
        }
        //updating frequency of array
        for (int i = 0; i <n ; i++) {
            freq1[s1.charAt(i)-'a']++;
        }
        //updating frequency array for first window
        for (int i = 0; i <n ; i++) {
            freq2[s2.charAt(i)-'a']++;
        }
        if (check(freq1,freq2)){
            return true;
        }
        int windowend=n;
        while (windowend<m){//checking window till end of str2
            freq2[s2.charAt(windowend)-'a']++;
            freq2[s2.charAt(windowend-n)-'a']--;
            if (check(freq1,freq2))return true;
            windowend++;
        }

     return false;
    }
}
