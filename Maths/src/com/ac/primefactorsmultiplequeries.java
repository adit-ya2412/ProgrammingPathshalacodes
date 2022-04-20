package com.ac;

import java.util.Scanner;

public class primefactorsmultiplequeries {
    public static void main(String[] args) {
        int n = 1000000 + 1;
        long[] nums = new long[n];
        long[] spf = generatespf(nums);
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            long num = sc.nextInt();
            long currdivisor = spf[(int)num];

            int noftimes = 0;
            while (spf[(int)num] != -1) {
                if (spf[(int)num] == currdivisor) {
                    noftimes++;
                    num=num/spf[(int)num];
                } else {
                    System.out.println(currdivisor+" "+noftimes);
                    currdivisor = spf[(int)num];
                    noftimes=1;
                    num=num/spf[(int)num];

                }

            }


            if (num!=0){
                if (num!=currdivisor&&currdivisor!=-1){
                    System.out.println(currdivisor+" "+noftimes);
                    System.out.println(num+" "+"1");
                }else {
                    System.out.println(num+" "+(noftimes+1));
                }

            }
            t--;
        }
    }
    static long[] generatespf(long[]nums) {
        int nn=(int) nums.length;
        long[] spf = new long[nn];
        for (int i = 2; i <nn; i++) {
            nums[i] = 1;
            spf[i] = -1;
        }
        for (int i = 2; i <= Math.sqrt(nn); i++) {
            if (nums[i] == 1) {
                for (int j = i; j * i < nn; j++) {
                      if (nums[i*j]==1){
                          spf[i*j]=i;
                          nums[i*j]=0;
                      }
                }
            }
        }
        return spf;
    }
}
