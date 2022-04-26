package com.ac;

import java.util.Scanner;

public class codechefstartersaprilq1 {
    public static void main(String[] args) {
//     Scanner sc=new Scanner(System.in);
//     int t=sc.nextInt();
//     while (t!=0){
//         int n=sc.nextInt();
//         System.out.println(2*n);
//         t--;
//     }
//        Scanner sc=new Scanner(System.in);
//        int t=sc.nextInt();
//        while (t!=0){
//            int n=sc.nextInt();
//            int x=sc.nextInt();
//            if (x%n==0) System.out.println("Yes");
//            else System.out.println("No");
//            t--;
//        }
//        Scanner sc=new Scanner(System.in);
//        int t=sc.nextInt();
//        while (t!=0){
//            long p=sc.nextLong();
//            long th=sc.nextLong();
//            System.out.println(Math.abs(p-th));
//            t--;
//        }
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t!=0){
            long changes=sc.nextLong();
            int intial=sc.nextInt();
            if (intial==1){
                if (changes%4==0){
                    System.out.println("On");
                }else System.out.println("Ambiguous");
            }else {
                if (changes%4==0){
                    System.out.println("Off");
                }else System.out.println("On");
            }
            t--;
//            changes=changes%4;
//            long ans=changes+intial;
//            if (ans<4){
//                if (ans>=1&&ans<=3){
//                    System.out.println("On");
//                }else System.out.println("off");
//            }else System.out.println("Ambigous");

        }
    }
}
