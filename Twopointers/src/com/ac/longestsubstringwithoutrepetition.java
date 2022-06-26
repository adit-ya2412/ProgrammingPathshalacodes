package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class longestsubstringwithoutrepetition {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String input=(in.readLine().trim());
        printsubstring(input);
    }
    static void printsubstring(String input){
        int ans=1;
        int[]freq=new int[256];
        int i=0,j=0;
        freq[input.charAt(i)]++;
        while (j<input.length()-1){
            if (freq[input.charAt(j+1)]==0){
                freq[input.charAt(j+1)]++;
                j++;
            }else {
                freq[input.charAt(i)]--;
                i++;
            }
            ans=Math.max(ans,j-i+1);
        }
        System.out.println(ans);
    }

}
