package com.ac;

import java.util.ArrayList;
import java.util.List;

public class noofdivisiors {
    public static void main(String[] args) {
        int[]arr={24,12,5};
        System.out.println(numberofdivisiors(arr));
    }
    static List numberofdivisiors(int[] nums) {
        List<Integer>ans=new ArrayList<>();

        for (int i = 0; i <nums.length; i++) {
            int noofways=1;
            int[] nofways = primefreq(nums[i]);
            int n1=nums[i];
            int currdivisor=nofways[n1];
            int nooftime=0;
            while (nofways[n1]!=-1){
                if (nofways[n1]==currdivisor){
                    nooftime++;
                }else {
                    noofways *=(nooftime+1);
                    currdivisor=nofways[n1];
                }
                n1=n1/nofways[n1];

            }
            noofways *=(nooftime+1);
            if (n1!=0){
                noofways*=2;
            }
            ans.add(noofways);

        }
        return ans;
    }

    static int[] primefreq(int n) {
        int[] prime = new int[n + 1];
        int[] spff = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            prime[i] = 1;
            spff[i] = -1;
        }
        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == 1) {
                for (int j = i; j * i <= n; j++) {
                    if (prime[i * j] == 1) {
                            spff[i*j]=i;
                            prime[i * j] = 0;
                    }
                }
            }
        }
        return spff;
    }
}
