package com.ac;

import java.util.*;

public class uglynumberII {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        //System.out.println(nthUglyNumbertp(n));
        System.out.println(nthUglyNumberPriority(n));
    }
    static int nthUglyNumbertp(int n){
        int[]arr=new int[n];
        int p1=0,p2=0,p3=0;
        arr[0]=1;
        int curr;
        for (int i = 1; i <=n-1 ; i++) {
            curr=Math.min(Math.min(2*arr[p1],3*arr[p2]),5*arr[p3]);
            arr[i]=curr;
            if (curr==arr[p1]*2)p1++;
            if (curr==arr[p2]*3)p2++;
            if (curr==arr[p3]*5)p3++;
        }
        return arr[n-1];
    }
    static int nthUglyNumberPriority(int n){
        PriorityQueue<Long>queue=new PriorityQueue<>();
        HashMap<Long,Boolean>map=new HashMap<>();
        queue.add(1l);
        map.put(1l,true);
        List<Integer>num=new ArrayList<>();
        num.add(2);
        num.add(3);
        num.add(5);
        long x=1;
        for (int i = 0; i <n ; i++) {
             x=queue.poll();
            for (int j = 0; j <num.size() ; j++) {
                if (!map.containsKey(num.get(j)*x)){
                    map.put(num.get(j)*x,true);
                    queue.add(num.get(j)*x);
                }
            }
        }
        return (int) x;
    }
}
