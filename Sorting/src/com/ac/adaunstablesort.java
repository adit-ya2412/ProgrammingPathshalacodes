package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class adaunstablesort {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        String[]elements=(in.readLine().trim()).split("\\s+");
        List<indexandvalues>pairs=new ArrayList<>();
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            pairs.add(new indexandvalues(i+1,Integer.parseInt(elements[i])));
        }
        Collections.sort(pairs,new sortingwrttoindex());
        for (int i = 0; i <n ; i++) {
            arr[i]=pairs.get(i).ind;
        }
        System.out.println(Arrays.toString(arr));
    }

}
class sortingwrttoindex implements Comparator<indexandvalues>{
    @Override
    public int compare(indexandvalues o1,indexandvalues o2){
        if (o1.value<o2.value)return -1;
        else if (o1.value==o2.value){
            if (o1.ind<o2.ind)return 1;
            else return -1;
        }else return 1;
    }
}
class  indexandvalues{
    int ind;
    int value;
    indexandvalues(int ind,int value){
        this.ind=ind;
        this.value=value;
    }
}
