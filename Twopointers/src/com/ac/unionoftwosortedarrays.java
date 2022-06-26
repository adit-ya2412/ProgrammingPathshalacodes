package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class unionoftwosortedarrays {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine().trim());
        int[] arr1 = new int[n];
        int m = Integer.parseInt(in.readLine().trim());
        int[] arr2 = new int[m];
        String[] el1 = (in.readLine().trim()).split("\\s+");
        String[] ele2 = (in.readLine().trim()).split("\\s+");
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(el1[i]);
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(ele2[i]);
        }
        System.out.println(union(arr1, arr2, n, m));
    }

    static ArrayList<Integer> union(int[] arr1, int[] arr2, int n, int m) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                if (ans.size() != 0 && ans.get(ans.size() - 1) == arr1[i]) i++;
                else {
                    ans.add(arr1[i]);
                    i++;
                }
            } else if (arr1[i] > arr2[j]) {
                if (ans.size() != 0 && ans.get(ans.size() - 1) == arr2[j]) j++;
                else {
                    ans.add(arr2[j]);
                    j++;
                }
            } else {
                if (ans.size() != 0 && ans.get(ans.size() - 1) == arr1[i]) {
                    i++;
                    j++;
                } else {
                    ans.add(arr1[i]);
                    i++;
                    j++;
                }
            }
        }
        while (i < n) {
            if (ans.size() != 0 && ans.get(ans.size() - 1) == arr1[i]) i++;
            else {
                ans.add(arr1[i]);
                i++;
            }
        }
        while (j < m) {
            if (ans.size() != 0 && ans.get(ans.size() - 1) == arr2[j]) j++;
            else {
                ans.add(arr2[j]);
                j++;
            }
        }
        return ans;
    }
}
