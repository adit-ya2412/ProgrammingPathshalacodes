package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class subarrayminimums {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int[]arr=new int[n];
        String[]ele=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(ele[i]);
        }
        System.out.println(sumSubarrayMins(arr));

    }
    static int sumSubarrayMins(int[]arr){
        int []nsm=new int[arr.length];
        int[]psem=new int[arr.length];
        Stack<Integer>sta=new Stack<>();
        sta.push(0);
        for (int i = 1; i <arr.length ; i++) {
            while (!sta.empty()&&(arr[sta.peek()]>arr[i])){
                nsm[sta.pop()]=i;
            }
            sta.push(i);
        }
        while (!sta.empty()){
            nsm[sta.pop()]=arr.length;
        }
        sta.push(arr.length-1);
        for (int i=arr.length-2;i>=0;i--){
            while (!sta.empty()&&(arr[sta.peek()]>=arr[i])){
                psem[sta.pop()]=i;
            }
            sta.push(i);
        }
        while (!sta.empty()){
            psem[sta.pop()]=-1;
        }
        long ans=0;
        long mod= (long) (Math.pow(10,9)+7);
         long con;
        for (int i = 0; i <arr.length ; i++) {
             con=(((arr[i])%mod)*((((i-psem[i])%mod)*((nsm[i]-i)%mod))%mod)%mod);
            ans=(ans%mod+con%mod)%mod;
        }
        return (int)ans;
    }
}
