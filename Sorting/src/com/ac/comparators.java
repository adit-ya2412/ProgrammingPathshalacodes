package com.ac;

import java.util.*;

class dataandfrequency{
    int dat;
    int freq;
    dataandfrequency(int dat,int freq){
        this.dat=dat;
        this.freq=freq;
    }
}
class sortbyfrq implements Comparator<dataandfrequency>{
    @Override
    public int compare(dataandfrequency obj1,dataandfrequency obj2){
        if (obj1.freq<obj2.freq)return 1;
        else if (obj1.freq==obj2.freq){
            if (obj1.dat<obj2.dat)return -1;
            else if (obj1.dat==obj2.dat)return 0;
            else return 1;
        }else return -1;
    }
}
public class comparators {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();


        while (t!=0){
            int n=sc.nextInt();
            int[]arr=new int[n];
            for (int i = 0; i <n ; i++) {
                arr[i]=sc.nextInt();
            }
            sortbyfrequency(arr,n);
            t--;
        }
    }
    static void sortbyfrequency(int[]arr,int n){

        int[]freq=frequency(arr);
        ArrayList<dataandfrequency>list=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            list.add(new dataandfrequency(arr[i],freq[arr[i]-1]));
        }
        Collections.sort(list,new sortbyfrq());
        int[]ans=new int[n];
        for (dataandfrequency obj:list) {
            System.out.print(obj.dat+" ");
        }
        System.out.println();
    }

    static int[]frequency(int[]arr){
        int[]ans=new int[60];
        for (int i = 0; i <arr.length ; i++) {
            ans[arr[i]-1]++;
        }
        return ans;
    }


}
