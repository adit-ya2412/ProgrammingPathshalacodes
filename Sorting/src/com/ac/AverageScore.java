package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AverageScore {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int[]arr=new int[n];
        String[]count=(br.readLine().trim()).split("\\s+");
        int a=Integer.parseInt(count[0]);
        int b=Integer.parseInt(count[1]);
        String []marks=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <marks.length ; i++) {
            arr[i]=Integer.parseInt(marks[i]);
        }
        int[]ans=maxavg(n,arr,a,b);
        for (int i:ans) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    static int[]maxavg(int n,int[]marks,int a,int b){
        List<marksandindex>ls=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            ls.add(new marksandindex(marks[i],i));
        }
        int[]ans=new int[n];
        if (b>a){
            Collections.sort(ls,new sortbyindex1());
            int i;
            for (i = ls.size()-1; i >=ls.size()-a ; i--) {
                ans[ls.get(i).indx]=1;
            }
            while (i>=0){
                ans[ls.get(i).indx]=2;
                i--;
            }
            return ans;
        }else if (a>b){
            Collections.sort(ls,new sortbyindex2());
            int i;
            for (i =ls.size()-1; i >=ls.size()-b ; i--) {
                ans[ls.get(i).indx]=2;
            }
            while (i>=0){
                ans[ls.get(i).indx]=1;
                i--;
            }
        }else {
            int i=0;
            while (i<n){
                if (i<(a+b)/2){
                    ans[i]=1;
                    i++;
                }else {
                    ans[i]=2;
                    i++;
                }
            }
        }
       return ans;
    }
}
class marksandindex{
    int marks;
    int indx;
    marksandindex(int m,int idx){
        this.marks=m;
        this.indx=idx;
    }
}
class sortbyindex2 implements Comparator<marksandindex>{
    @Override
    public int compare(marksandindex o1,marksandindex o2){
        if (o1.marks!=o2.marks)return Integer.compare(o1.marks,o2.marks);
        else {
            return Integer.compare(o1.indx,o2.indx);
        }
    }
}
class sortbyindex1 implements Comparator<marksandindex>{
    @Override
    public int compare(marksandindex o1,marksandindex o2){
        if (o1.marks!=o2.marks)return Integer.compare(o1.marks,o2.marks);
        else {
            if (o1.indx<o2.indx)return 1;
            else return -1;
        }
    }
}
