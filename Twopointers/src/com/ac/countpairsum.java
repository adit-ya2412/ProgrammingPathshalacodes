package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InaccessibleObjectException;

public class countpairsum {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]elements=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        int sum=Integer.parseInt(in.readLine().trim());
        System.out.println(countPairs(arr,sum));
    }
    static int countPairs(int[]arr,int sum){
        int i=0;
        int h=arr.length-1;
        int ans=0;
        int curr=0;
        while (i<h){
            curr=arr[i]+arr[h];
            if (curr==sum){
                if (arr[i]==arr[h]){
                    int l=h-i+1;
                  ans+=((l*(l-1))/2);
                  break;
                }else {
                    int v1=arr[i];
                    int v2=arr[h];
                    int c1=0,c2=0;
                    while (arr[i]==v1){
                        i++;
                        c1++;
                    }
                    while (arr[h]==v2)
                    {
                        h--;
                        c2++;
                    }
                    ans+=(c1*c2);
                }
            }else if (curr<sum)i++;
            else h--;
        }
        return ans;
    }
}
