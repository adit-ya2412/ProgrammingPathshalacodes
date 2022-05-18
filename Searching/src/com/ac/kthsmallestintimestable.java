package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kthsmallestintimestable {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(inp.readLine().trim());
        while (t != 0) {
            String[] input = (inp.readLine().trim()).split("\\s+");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);
            System.out.println(findsmallestk(m, n, k));
            t--;
        }
    }
    static int findpos(int mid,int n,int m){
        int count=0;
        for (int i = 1; i <=m ; i++) {
            if (i*n<=mid){
                count+=n;
            }else {
                boolean found=false;
                int st=i;
                int end=i*n;
                while (st<=end){
                    int middle=st+(end-st)/2;
                    if (middle<mid){
                        st=middle+1;
                    }else if (middle>mid){
                        end=middle-1;
                    }else {
                        found=true;
                        count+=middle/i;
                        break;
                    }
                }
                if (!found){
                    count+=(end)/i;
                }
            }
        }
        return count;
    }
    static int findsmallestk(int m,int n,int k){
        int l=1;
        int h=m*n;
        while (l<=h){
            int mid=l+(h-l)/2;
            if (findpos(mid,n,m)>=k){
                if (findpos(mid-1,n,m)<k)return mid;
                else h=mid-1;
            }else l=mid+1;
        }
        return -1;
    }

}
