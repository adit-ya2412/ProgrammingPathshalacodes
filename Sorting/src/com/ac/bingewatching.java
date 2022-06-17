package com.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//// code is wrong

public class bingewatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Float> lis = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            float kk = sc.nextFloat();
            lis.add((float) (Math.round(kk * 100.0) / 100.0));
        }
        System.out.println(mindays(lis));
    }

    static int mindays(List<Float> durations) {
        float ttwatchtime = 0;
        for (int i = 0; i < durations.size(); i++) {
            ttwatchtime += durations.get(i);
        }

        int l = 0;
        int h = durations.size();
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (3.0 * mid > ttwatchtime) {
                if (3.0 * (mid - 1) <= ttwatchtime) return mid;
                else h = mid - 1;
            } else l = mid + 1;
        }
        return -1;
    }
}
//    static boolean check(List<Float>durations,int days){
//        float ttwatchtime=0;
//        int daycount=1;
//        for (int i = 0; i < durations.size() ; i++) {
//               ttwatchtime=durations.get(i);
//               float search= (float) (3.0-ttwatchtime);
//            for (int j = 0; j <durations.size() ; j++) {
//                if (j!=i&&durations.get(j)<search){
//
//                }
//            }
//        }
//
//}
