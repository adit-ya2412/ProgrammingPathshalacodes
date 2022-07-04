package com.ac;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class noofpointsonstraightline {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine().trim());
        int[][]points=new int[n][2];

        for (int i = 0; i <n ; i++) {
            String[]inputs=(br.readLine().trim()).split("\\s+");
            points[i][0]=Integer.parseInt(inputs[0]);
            points[i][1]=Integer.parseInt(inputs[1]);
        }
        System.out.println(countpairs(points));
        //System.out.println(gcdrecursive(0,12));
    }
    static int countpairs(int[][]poi){
        HashMap<String,Integer>map=new HashMap<>();
        int ans=1;
        for (int i = 0; i <poi.length ; i++) {
               int refx=poi[i][0];
               int refy=poi[i][1];
               int olp=0,maxm=0;
            for (int j =i+1; j <poi.length ; j++) {
                  if (poi[i][0]==poi[j][0]&&poi[i][1]==poi[j][1]){
                      olp++;

                  }else {
                      int xdiff=poi[j][0]-refx;
                      int ydiff=poi[j][1]-refy;
                      int hcf=gcdrecursive(Math.abs(xdiff),Math.abs(ydiff));
                      xdiff/=hcf;
                      ydiff/=hcf;
//                      int deltax=xdiff/hcf;
//                      int deltay=ydiff/hcf;
                      //int[]A=standardize(deltax,deltay);
                      int[]A=standardize(xdiff,ydiff);
                      //pair p=new pair(deltax,deltay);
//                      deltax=A[0];
//                      deltay=A[1];
//                      String p=conctenate(deltax,deltay);
                      xdiff=A[0];
                      ydiff=A[1];
                      String p=conctenate(xdiff,ydiff);
                      int cnt=map.getOrDefault( p,0);
                      if (cnt==0){
                          map.put(p,1);
                      }else map.put(p,cnt+1);
                      maxm=Math.max(maxm,map.getOrDefault(p,0));

                  }
            }
            ans=Math.max(ans,1+olp+maxm);
            map.clear();
        }
        return ans;
    }
    static int[]standardize(int num,int denom){
        if (num==0)denom=1;
        if (denom==0)num=1;
        if ((num<0&&denom<0)||(denom<0)){
            num*=-1;
            denom*=-1;
        }
        return new int[]{num,denom};
    }
    static int gcd(int xdiff,int ydiff){
        if (xdiff==0||ydiff==0)return Math.max(xdiff,ydiff);
        int dividend=Math.max(xdiff,ydiff);
        int divisor=Math.min(xdiff,ydiff);
        while (divisor!=0){
            if (dividend%divisor==0)return divisor;
            else {
                int temp=dividend%divisor;
                dividend=divisor;
                divisor=temp;
            }
        }
        return 1;
    }
    static int gcdrecursive(int xdiff,int ydiff){
        if (xdiff==0)return ydiff;
        if (ydiff==0)return xdiff;
        int m1=Math.max(xdiff,ydiff);
        int m2=Math.min(xdiff,ydiff);
        if (m1%m2==0)return m2;
        return gcdrecursive(m2,m1%m2);
    }
    static String conctenate(int xdiff,int ydiff){
        return xdiff+"/"+ydiff;
    }
}
class pair{
    int x;
    int y;
    pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
