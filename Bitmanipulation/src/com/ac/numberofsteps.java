package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class numberofsteps {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String input=(in.readLine().trim());
        StringBuilder st=new StringBuilder(input);
        System.out.println(numSteps(st));

    }
    static int numSteps(StringBuilder s) {
        int step=0;
        while (s.length() > 1) {
            if (checkifeven(s)) {
                s.deleteCharAt(s.length()-1);
                step++;
            }else {
                boolean foundzero=false;step++;
                for (int i = s.length()-1; i >=0 ; i--) {
                    if (s.charAt(i)=='0'){
                        foundzero=true;
                        s.deleteCharAt(i);
                        s.insert(i,'1');
                        break;
                    }else {
                        s.deleteCharAt(i);
                        s.insert(i,'0');
                    }
                }
                if (foundzero==false)s.insert(0,'1');
            }
        }
        return step;
    }
    static boolean checkifeven(StringBuilder s){
        if (s.charAt(s.length()-1)=='0')return true;
        else return false;
    }
}
