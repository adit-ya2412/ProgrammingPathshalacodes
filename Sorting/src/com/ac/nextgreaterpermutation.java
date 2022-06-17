package com.ac;
import java.io.*;
import java.util.*;
public class nextgreaterpermutation {
    public static void main(String[] args)throws IOException {
      BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
      int n=Integer.parseInt(in.readLine().trim());
      String[]inputs=(in.readLine().trim()).split("\\s+");
      int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(inputs[i]);
        }
        nextgreater(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void nextgreater(int[]arr){
        int i= arr.length-1;
        while (i!=0&&(arr[i-1]>=arr[i])){
            i--;
        }
        if (i-1>=0){
            for (int j = arr.length-1; j >=i ; j--) {
                if (arr[j]>arr[i-1]){
                    int temp=arr[i-1];
                    arr[i-1]=arr[j];
                    arr[j]=temp;
                    break;
                }
            }
            int x=i;
            int y=arr.length-1;
            while (x<y){
                int temp=arr[x];
                arr[x]=arr[y];
                arr[y]=temp;
                x++;
                y--;
            }
        }else {
            Arrays.sort(arr);
        }
    }
}
