package com.ac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class pair{
    int x;
    int y;
    pair(int x,int y){
        this.x=x;
        this.y=y;
    }

}
class sortbyeuclidean implements Comparator<pair>{
    @Override
    public int compare(pair ob1,pair ob2){
        double l1=(ob1.x*ob1.x)+(ob1.y*ob1.y);
        double l2=(ob2.x*ob2.x)+(ob2.y*ob2.y);
        if (l1<l2)return -1;
        else if (l1==l2)return 0;
        else return 1;
    }
}

public class Kclosestpair {
    public static void main(String[] args) {
        //int[][]arr={{3,3},{5,-1},{-2,4}};
        int[][]arr={{-5,4},{-6,-5},{4,6}};
        int k=2;
        int[][]ans=kclose(arr,k);
        for (int[]ar:ans) {
            System.out.println(Arrays.toString(ar));
        }

    }
    static int[][]kclose(int[][]arr,int k){
        ArrayList<pair>list=new ArrayList<>();
        for (int i = 0; i <arr.length ; i++) {
            list.add(new pair(arr[i][0],arr[i][1]));
        }

        Collections.sort(list,new sortbyeuclidean());
//        System.out.println(list);
        int[][]ans=new int[k][2];
        for (int i = 0; i <k ; i++) {

            ans[i][0]=list.get(i).x;
            ans[i][1]=list.get(i).y;
        }
        return ans;
        }

    }

