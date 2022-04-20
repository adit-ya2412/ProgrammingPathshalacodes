package com.ac;

import java.util.Scanner;

public class trianglepossible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }




        int n1 = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n1; i++) {
            b[i] = sc.nextInt();
        }




        int n3 = sc.nextInt();
        int[] c = new int[n3];
        for (int i = 0; i < n3; i++) {
            c[i] = sc.nextInt();
        }


    triang(a, b, c);


}

    static void triang(int[]a,int[]b,int[]c){
        for (int i = 0; i <a.length ; i++) {
            int at=a[i];
            int bt=b[i];
            int ct=c[i];
            int max=Math.max(at,bt);
            max=Math.max(max,ct);
            int max2;
            if (max==ct){
                if ((at+bt)>ct){
                    System.out.println("Yes");
                }else {
                    System.out.println("NO");
                }
            }else if (max==at){
                if ((bt+ct)>at){
                    System.out.println("Yes");
                }else {
                    System.out.println("NO");
                }
            }else if (max==bt){
                if ((at+ct)>bt) System.out.println("Yes");
                else {
                    System.out.println("NO");
                }
            }
        }
    }
}
