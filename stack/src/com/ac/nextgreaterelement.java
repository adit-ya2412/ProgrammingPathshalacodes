package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class nextgreaterelement {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int[]arr=new int[n];
        String[]inputs=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(inputs[i]);
        }
        int[]ans=nextgreat(arr,n);
        for (int i:ans) {
            System.out.print(i+",");
        }

    }
    static int[]nextgreat(int[]arr,int n){
        int[]ans=new int[n];
        Stack<Integer>st=new Stack<>();
        st.push(0);
        for (int i = 1; i <n ; i++) {
            while (!st.empty()&&arr[i]>arr[st.peek()]){
                ans[st.peek()]=arr[i];
                st.pop();
            }
            st.push(i);
        }
        while (!st.empty()){
            ans[st.peek()]=-1;
            st.pop();
        }
        return ans;
    }

}
