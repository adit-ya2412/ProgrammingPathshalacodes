package com.ac;

import java.util.*;

public class CarFleet {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]position=new int[n];
        int[]speeds=new int[n];
        for (int i = 0; i <n ; i++) {
            position[i]=sc.nextInt();}
        for (int i = 0; i <n ; i++) {
            speeds[i]=sc.nextInt();
        }
        int target=sc.nextInt();

        System.out.println(nofleets(target,position,speeds));

    }
    static int nofleets(int target,int[]positions,int[]speeds){
        List<pairofposandtime>list=new ArrayList<>();
        for (int i = 0; i <positions.length ; i++) {
            list.add(new pairofposandtime(positions[i],(double)(target - positions[i]) / speeds[i]));
        }
        Collections.sort(list,new comparebypos());
        int count=0;
        double lasttime=-1;
        for (int i = list.size()-1; i >=0 ; i--) {
            if (list.get(i).time>lasttime){
                lasttime=list.get(i).time;
                count++;
            }
        }
        return count;
    }
}
class pairofposandtime{
    int pos;
    double time;
    pairofposandtime(int pos,double time ){
        this.pos=pos;
        this.time=time;
    }
}
class comparebypos implements Comparator<pairofposandtime>{
    @Override
    public int compare(pairofposandtime o1,pairofposandtime o2){
        return Integer.compare(o1.pos,o2.pos);
    }
}
