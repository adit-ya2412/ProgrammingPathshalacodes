package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class sumofsubset {
    public static void main(String[] args)throws IOException {
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(inp.readLine().trim());
        String[]elements=(inp.readLine().trim()).split("\\s+");
        List<Integer>arr=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            arr.add(Integer.parseInt(elements[i]));
        }
        ArrayList<Integer>ans=new ArrayList<>();
        print(0,arr,0,ans);

    }
    static void print(int s,List<Integer>arr,int i,List<Integer>ans){
        if (i== arr.size()){
            ans.add(s);
            return;
        }
            //yes
            print(s+ arr.get(i),arr,i+1,ans);
            //no
            print(s,arr,i+1,ans);

    }
}
