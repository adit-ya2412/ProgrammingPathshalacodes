package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BinaryMatrix2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine().trim());
        int n = Integer.parseInt(br.readLine().trim());
        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            String[]elements=(br.readLine().trim()).split("\\s+");
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(elements[j])==1){
                    arr[i][j]=49;
                }else arr[i][j]=48;
            }
        }
        System.out.println(maximalRectangle(arr));

    }

    static int maximalRectangle(char[][] matrix) {
        int[][] arr = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    arr[i][j] = 1;
                } else arr[i][j] = 0;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (arr[i][j] != 0) {
                    arr[i][j]=(1 + arr[i - 1][j]);
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        int[] nse = new int[matrix[0].length];
        int[] pse = new int[matrix[0].length];
        int ht;
        Stack<Integer> st = new Stack<>();
        for (int i = matrix.length - 1; i >= 0; i--) {
            st.push(0);
            for (int j = 1; j < matrix[i].length; j++) {
                while (!st.empty() && arr[i][st.peek()] > arr[i][j]) {
                    nse[st.peek()] = j;
                    st.pop();
                }
                st.push(j);
            }
            while (!st.empty()) {
                nse[st.peek()] = matrix[i].length;
                st.pop();
            }
            st.push(matrix[i].length - 1);
            for (int j = matrix[i].length - 2; j >= 0; j--) {
                while (!st.empty() && arr[i][st.peek()] > arr[i][j]) {
                    pse[st.peek()] = j;
                    st.pop();
                }
                st.push(j);
            }
            while (!st.empty()) {
                pse[st.peek()] = -1;
                st.pop();
            }
            for (int j = 0; j < matrix[i].length; j++) {
                ht = arr[i][j];
                ans = Math.max(ans, (ht * (nse[j] - pse[j] - 1)));
            }
        }
        return ans;
    }
}
