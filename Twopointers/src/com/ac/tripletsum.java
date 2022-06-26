package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tripletsum {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]ele=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(ele[i]);
        }
        Arrays.sort(arr);
        int sum=Integer.parseInt(in.readLine().trim());
        List<List<Integer>>ans=printtriplets(arr,sum);
        for (List<Integer>a:ans) {
            System.out.println(a);
        }

    }
    static List<List<Integer>> printtriplets(int[]arr, int sum) {
        List<List<Integer>>ans=new ArrayList<>();
        int fix = 0, l, h;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            else {
                fix = sum - arr[i];
                l = i + 1;
                h = arr.length - 1;
                while (l < h) {
                    int curr = arr[l] + arr[h];
                    if (curr == fix) {
                        List<Integer>temp=new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[l]);
                        temp.add(arr[h]);
                        ans.add(new ArrayList<>(temp));
                        if (arr[l]==arr[h])break;
                        int v1 = arr[l];
                        while (arr[l] == v1) {
                            l++;
                        }
                        int v2 = arr[h];
                        while (arr[h] == v2) {
                            h--;
                        }
                    } else if (curr > fix) {
                        h--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return ans;
    }
}
