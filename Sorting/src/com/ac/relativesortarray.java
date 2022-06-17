package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class relativesortarray {
    public static void main(String[] args) throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n1=Integer.parseInt(in.readLine().trim());
        int n2=Integer.parseInt(in.readLine().trim());
        String[]ele1=(in.readLine().trim()).split("\\s+");
        String[]ele2=(in.readLine().trim()).split("\\s+");
        int[]arr1=new int[n1];
        for (int i = 0; i <n1 ; i++) {
            arr1[i]=Integer.parseInt(ele1[i]);
        }
        int[]arr2=new int[n2];
        for (int i = 0; i <n2; i++) {
            arr2[i]=Integer.parseInt(ele2[i]);
        }
        int[]ans=relasort(arr1,arr2);
        System.out.println(Arrays.toString(ans));

    }
    static int[]relasort(int[]arr1,int []arr2){
           int[]ranks=new int[1001];
        for (int i = 0; i < arr2.length ; i++) {
            ranks[arr2[i]]=i+1;
        }
        List<pairs>li=new ArrayList<>();
        for (int i = 0; i < arr1.length ; i++) {
            li.add(new pairs(arr1[i],ranks[arr1[i]]));
        }
        Collections.sort(li,new sortrelativily());
        int[]ans=new int[arr1.length];
        for (int i=0;i< arr1.length;i++){
            ans[i]=li.get(i).value;
        }
        return ans;
    }
}
class pairs{
    int value;
    int rank;
    pairs(int value,int rank){
        this.value=value;
       this.rank=rank;
    }
}
class sortrelativily implements Comparator<pairs>{
    @Override
    public int compare(pairs obj1,pairs obj2){
        if (obj1.rank==0&&obj2.rank==0){
            return Integer.compare(obj1.value,obj2.value);
        }else {

            if (obj1.rank==0&&obj2.rank>=1)return 1;
            else if (obj1.rank>=1&&obj2.rank==0)return -1;
            else if (obj1.rank<obj2.rank)return -1;
            else if (obj1.rank==obj2.rank)return 0;
            else return 1;
        }
    }
}
