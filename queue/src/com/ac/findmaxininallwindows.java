package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class findmaxininallwindows {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int[]arr=new int[n];
        String[]ele=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(ele[i]);
        }
        int k=Integer.parseInt(br.readLine().trim());
        System.out.println(Arrays.toString(maxSlidingwindow(arr,k)));
    }
    static int[] maxSlidingwindow(int[]nums,int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> d = new LinkedList<>();

        for (int i = 0; i < k; i++) {

                while (!d.isEmpty() && nums[d.peekFirst()] <=nums[i] ) {
                    d.removeFirst();
                }
                d.addFirst(i);
        }

        for (int i =k; i <nums.length ; i++) {
            ans[i - k] = nums[d.peekLast()];
            if (d.peekLast() == i - k) {
                d.removeLast();
            }
            while (!d.isEmpty() && nums[d.peekFirst()] <= nums[i]) {
                d.removeFirst();
            }
            d.addFirst(i);
        }
             ans[nums.length-k]=nums[d.peekLast()];
        return ans;
    }

    }

