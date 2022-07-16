package com.ac;

import java.util.*;

public class binaryforms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<String> qq = new LinkedList<>();
        List<String>ans=new ArrayList<>();
        qq.add("1");
        int cnt=1,s=1;
        while (cnt<=n){
            String x=qq.poll();
            ans.add(x);
            cnt++;
            if (s<n){
                qq.add(x+"0");
                qq.add(x+"1");
                s+=2;
            }
        }
        System.out.println(ans);
    }
}
