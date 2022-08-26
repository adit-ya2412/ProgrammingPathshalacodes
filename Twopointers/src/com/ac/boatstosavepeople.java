package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.BatchUpdateException;
import java.util.Arrays;
import java.util.Locale;

public class boatstosavepeople {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int []arr=new int[n];
        String[]inputs=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(inputs[i]);
        }
        int limit=Integer.parseInt(br.readLine().trim());
        System.out.println(findnumber(arr,limit));
    }
    static int findnumber(int[]arr,int limit){
        int cnt=0;
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        while (j>=i){
            if (arr[j]+arr[i]<=limit){
                j--;
                i++;
                cnt++;
            }else{
                j--;
                cnt++;
            }
        }
        return cnt;
    }
}
