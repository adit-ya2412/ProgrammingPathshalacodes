package com.ac;

import java.util.*;

public class TrainsandPlatform {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arrival_time=new int[n];
        int[]departure_time=new int[n];
        for (int i = 0; i <n ; i++) {
            arrival_time[i]=sc.nextInt();
            departure_time[i]=sc.nextInt();
        }
        //System.out.println(minimumnumber(arrival_time,departure_time,n));
        System.out.println(minimumnumberofplatforms(arrival_time,departure_time,n));
    }
    static int minimumnumber(int[]arrivaltime,int[]departuretime,int n){
        List<timewithaction>list=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            list.add(new timewithaction(arrivaltime[i],'a'));
            list.add(new timewithaction(departuretime[i],'d'));
        }
        Collections.sort(list,new Comparator<timewithaction>(){
            @Override
            public  int compare(timewithaction o1,timewithaction o2){
                if (o1.value!=o2.value)return o1.value-o2.value;
                else{
                    if (o1.action=='d'&&o2.action=='a')return -1;
                    else if (o1.action=='a'&&o2.action=='d')return 1;
                    else return 0;
                }
            }
        });

        int ans=Integer.MIN_VALUE;
        int curr=0;
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i).action=='a')curr++;
            else curr--;
            ans=Math.max(ans,curr);
        }
        return ans;
    }
    static int minimumnumberofplatforms(int[]arrivaltime,int[]departuretime,int n){
        Arrays.sort(arrivaltime);
        Arrays.sort(departuretime);
        int curr=0;
        int i=0;
        int j=0;
        int k=0;
        int ans=Integer.MIN_VALUE;
        while (i<n&&j<n){
            if (arrivaltime[i]<=departuretime[j]){
                i++;
                curr++;
                ans=Math.max(curr,ans);
            }else {
                j++;
                curr--;
            }
        }
        return ans;
    }
}
class timewithaction{
    int value;
    char action;
    timewithaction(int value,char action){
        this.action=action;
        this.value=value;
    }
}
