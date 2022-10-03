package com.ac;

import java.util.HashMap;
import java.util.Scanner;

public class countsubarrayswithsum0 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[]arr=new long[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextLong();
        }
        System.out.println(count(arr,n));
    }
    static long count(long[]arr,int n){
        long[]pref=new long[n];
        pref[0]=arr[0];
        for (int i = 1; i <n ; i++) {
            pref[i]=pref[i-1]+arr[i];
        }
        HashMap<Long,Long>map=new HashMap<>();
        map.put(0l,1l);
        for (int i = 0; i <n ; i++) {
            map.put(pref[i],map.getOrDefault(pref[i],0l)+1);
        }
        long cnt=0;
        for (Long i:map.keySet()){
            long e=map.get(i);
            cnt+=(e*(e-1))/2;
        }
        return cnt;
    }
}
