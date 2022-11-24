package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//incomplete
public class verbalairthmeticpuzzle {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]words=(br.readLine().trim()).split("\\s+");
        String result=(br.readLine().trim());
        System.out.println(isSolvable(words,result));

    }
    static boolean isSolvable(String[]words,String result){
        Set<Character>starting=new HashSet<>();
        for (int i=0;i<words.length;i++){
            starting.add(words[i].charAt(0));
        }
        starting.add(result.charAt(0));

    }
}
