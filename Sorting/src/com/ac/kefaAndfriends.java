package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class kefaAndfriends {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String[]inputs=(in.readLine().trim()).split("\\s+");
        int n=Integer.parseInt(inputs[0]);
        long diff=Long.parseLong(inputs[1]);
        List<moneyandfactor>ls=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            String[]inpu=(in.readLine().trim()).split("\\s+");
            ls.add(new moneyandfactor(Long.parseLong(inpu[0]),Long.parseLong(inpu[1])));
        }
        Collections.sort(ls,new sortonmoney());
        System.out.println(maxfactor(ls,diff));
    }
    static long maxfactor(List<moneyandfactor>ls,long diff){
        int i=0,j=0;
        long curr=ls.get(i).money;
        long currfactor=ls.get(i).factor;
        long ans=Long.MIN_VALUE;
        while (j< ls.size()-1){
            if ((ls.get(j+1).money-curr)<diff){
                j++;
                currfactor+=ls.get(j).factor;
            } else {
                ans=Math.max(currfactor,ans);
                currfactor-=ls.get(i).factor;
                i++;
                curr=ls.get(i).money;
            }
        }
        ans=Math.max(ans,currfactor);
        return ans;
    }
}
class moneyandfactor{
    long money;
    long factor;
    moneyandfactor(long money,long factor){
        this.money=money;
        this.factor=factor;
    }
}
class sortonmoney implements Comparator<moneyandfactor>{
    @Override
    public int compare(moneyandfactor o1,moneyandfactor o2){
        return  Long.compare(o1.money,o2.money);
    }
}
