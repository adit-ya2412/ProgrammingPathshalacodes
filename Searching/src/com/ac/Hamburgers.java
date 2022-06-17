package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Hamburgers {
    public static void main(String[] args)throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                String recepie = (in.readLine().trim());
                String[] inhouse = (in.readLine().trim()).split("\\s+");
                String[] prices = (in.readLine().trim()).split("\\s+");
                long money = Long.parseLong(in.readLine().trim());
                int burgerspresent = Integer.parseInt(inhouse[0]);
                int sausagepresent = Integer.parseInt(inhouse[1]);
                int cheesepresent = Integer.parseInt(inhouse[2]);
                int priceofburger = Integer.parseInt(prices[0]);
                int priceofsausage = Integer.parseInt(prices[1]);
                int priceofcheese = Integer.parseInt(prices[2]);
                int[] req = requirements(recepie);
                System.out.println(maxhams(req, money, burgerspresent, sausagepresent, cheesepresent, priceofburger, priceofsausage, priceofcheese));

    }
    static long maxhams(int[]req,long money,int burgerspresent,int sasusagepresent,int cheesepresent,int priceofburger,int priceofsausage,int priceofcheese){
        long l=0;
        long h= (long) Math.pow(10,12)+100;
        while (l<=h){
            long mid=l+(h-l)/2;
            long cost=ifpossible(mid,req,burgerspresent,sasusagepresent,cheesepresent,priceofburger,priceofsausage,priceofcheese);
            if (cost<money){
                if (ifpossible(mid+1,req,burgerspresent,sasusagepresent,cheesepresent,priceofburger,priceofsausage,priceofcheese)>money)return mid;
                else l=mid+1;
            }else if (cost>money){
                h=mid-1;
            }else {
                return mid;
            }
        }
        return h;
    }
    static long ifpossible(long hams,int[]req,int burgerspresent,int sausagepresent,int cheesepresent,int pricesofburger,int pricesofsausage,int pricesofcheese){
        long burgersrequired=hams*req[0];
        long sasusagesrequired=hams*req[1];
        long cheeserequired=hams*req[2];
        burgersrequired=burgersrequired-burgerspresent;
        sasusagesrequired=sasusagesrequired-sausagepresent;
        cheeserequired=cheeserequired-cheesepresent;
        long costtobuyburger=burgersrequired*pricesofburger;
        long costtobuysausagee=sasusagesrequired*pricesofsausage;
        long costtobuycheese=cheeserequired*pricesofcheese;
        long cost=0;
        if (costtobuyburger<0)cost+=0;
        else cost+=costtobuyburger;
        if (costtobuysausagee<0)cost+=0;
        else cost+=costtobuysausagee;
        if (costtobuycheese<0)cost+=0;
        else cost+=costtobuycheese;
        return cost;
    }

    static int[]requirements(String recepie){
        int[]ans=new int[3];
        for (int i = 0; i <recepie.length() ; i++) {
            if (recepie.charAt(i)=='B'){
                ans[0]++;
            }else if (recepie.charAt(i)=='S'){
                ans[1]++;
            }else if (recepie.charAt(i)=='C'){
                ans[2]++;
            }
        }
        return ans;
    }

}
