package com.ac;

import java.util.*;

public class activityselection {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]start_time=new int[n];
        int[]end_time=new int[n];
        for (int i = 0; i <n ; i++) {
            start_time[i]=sc.nextInt();
            end_time[i]=sc.nextInt();
        }
        System.out.println(maxactvitypossible(start_time,end_time,n));
    }
    static int maxactvitypossible(int[]starttime,int[]endtime,int n){
        List<startandendtime>list=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            list.add(new startandendtime(starttime[i],endtime[i]));
        }
        Collections.sort(list,new Comparator<startandendtime>(){
            @Override
            public int compare(startandendtime o1,startandendtime o2){
                return o1.end-o2.end;
            }
        });
        int currend=list.get(0).end;
        int ans=1;
        for (int i = 1; i <list.size() ; i++) {
            if (currend<=list.get(i).st){
                currend=list.get(i).end;
                ans++;
            }
        }
        return ans;
    }
}
class startandendtime{
    int st;
    int end;
    startandendtime(int st,int end){
        this.st=st;
        this.end=end;
    }
}
