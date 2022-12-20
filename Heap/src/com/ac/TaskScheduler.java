package com.ac;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char[]arr=new char[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.next().charAt(0);
        }
        int cooldownperiod=sc.nextInt();
        System.out.println(leastInterval(arr,cooldownperiod));
    }
    static int leastInterval(char[]tasks,int n){
//        PriorityQueue<Integer>queue=new PriorityQueue<>(new Comparator<Integer>(){
//            @Override
//            public  int compare(Integer o1,Integer o2){
//                return o2-o1;
//            }
//        });
        PriorityQueue<Integer>queue=new PriorityQueue<>((a,b)->b-a);
        int[]temp=new int[26];
        for (int i = 0; i <tasks.length ; i++) {
            temp[tasks[i]-65]++;
        }
        for (int i = 0; i <temp.length ; i++) {
            if (temp[i]>0)queue.add(temp[i]);
        }
        int ans=0;
        List<Integer>ttemp=new ArrayList<>();
        while (queue.size()>0){
            int cnt=0;
            while (cnt<=n){
                if (queue.size()==0){
                    if (ttemp.size()!=0)ans+=n-cnt+1;
                    break;
                }
                int x=queue.poll();
                if (x-1>0)ttemp.add(x-1);
                ans++;
                cnt++;
            }
            queue.addAll(ttemp);
            ttemp.clear();
        }
        return ans;
    }
}
