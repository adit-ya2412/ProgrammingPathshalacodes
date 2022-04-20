package com.ac;

import java.util.Arrays;
import java.util.Scanner;

public class missingnumberscodechef {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while (t!=0){
            long x=-1,y=-1;
            long[]arr=new long[4];
            for (int i = 0; i <4 ; i++) {
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            //for codition to check 1
            if (arr[1]==arr[2]&&(arr[0]==(arr[1]-1))&&(arr[3]==arr[1]+1)){
              x=arr[2];y=1;
            }else if ((arr[0]<0)&&(arr[1]==0)&&(arr[2]==Math.abs(arr[0]+1))&&(arr[2]==arr[3]-1)){
                x=1;
                y=arr[2];
            }else if (arr[0]<0){
                long a1,b1;
                a1=(arr[0]+arr[2])/2;
                b1=arr[2]-a1;
                if (a1*b1==arr[3]&&arr[1]==0){
                    x=a1;
                    y=b1;
                }
            }else {
                long a2,b2;
                a2=(arr[0]+arr[2])/2;
                b2=arr[2]-a2;
                if (a2*b2==arr[3]&&a2==arr[1]*b2){
                    x=a2;
                    y=b2;
                }
                long a3,b3;

            }
        }
    }
}
