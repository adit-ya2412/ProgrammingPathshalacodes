package com.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class greycodesequence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(grayCode(n));
    }
    static List<Integer>grayCode(int n){
        if(n==1){
            List<Integer>ans=new ArrayList<>();
            ans.add(0);
            ans.add(1);
            return ans;
        }
        List<Integer>grayn=grayCode(n-1);
        List<Integer>ans=new ArrayList<>();
        int mask=1<<n-1;
        for(int i=grayn.size()-1;i>=0;i--){
            ans.add(grayn.get(i)|mask);
        }
        for(int i=0;i<ans.size();i++){
            grayn.add(ans.get(i));
        }
        return grayn;
    }
}
