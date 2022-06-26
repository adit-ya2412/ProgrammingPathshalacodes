package com.ac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class intersectionofarrays {
    public static void main(String[] args) {
        int n1, n2;
        Scanner sc = new Scanner(System.in);
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        int[] ar1 = new int[n1];
        int[] ar2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            ar1[i] = sc.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            ar2[i] = sc.nextInt();
        }
        int[] ans = intersection(ar1, ar2);
        System.out.println(Arrays.toString(ans));
    }

    static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> ls = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                int p = nums1[i], q = nums2[j];
                ls.add(nums1[i]);
                i++;
                j++;
                while (i < nums1.length && nums1[i] == p) {
                    i++;
                }
                while (j < nums2.length && nums2[j] == q) {
                    j++;
                }

            } else if (nums1[i] < nums2[j]) {
                i++;
            } else j++;
        }
        int[] temp = new int[ls.size()];
        for (int k = 0; k < ls.size(); k++) {
            temp[k] = ls.get(k);
        }
        return temp;
    }
}
