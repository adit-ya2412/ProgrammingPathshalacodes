package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ehabisoddone {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        List<Integer>ar=new ArrayList<>();
        String[]input=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            ar.add(Integer.parseInt(input[i]));
        }
        List<Integer>ans=minlexi(ar);
        for (int a:ans) {
            System.out.print(a+" ");
        }
        System.out.println();
    }
    static List<Integer> minlexi(List<Integer>arr){
        boolean even=false,odd=false;
        for (int i = 0; i < arr.size() ; i++) {
            if (even&&odd)break;
            if (arr.get(i)%2==0){
                even=true;
            }else {
                odd=true;
            }
        }
        if (even&&odd){
            Collections.sort(arr);
            return arr;
        }else return arr;
    }
}
