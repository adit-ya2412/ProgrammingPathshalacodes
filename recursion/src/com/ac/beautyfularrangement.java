package com.ac;

public class beautyfularrangement {
    public static void main(String[] args) {
        int n=1;
        int[]num=new int[n];
        for (int i = 1; i <=n; i++) {
            num[i-1]=i;
        }
        beauty(num,0,n,0);
        System.out.println(count);
    }
    static int count=0;
    static void beauty(int[]num,int i,int n,int c){
        if (i==n){
            if (c==n){
                count++;
                return;
            }
            return;
        }
        for (int j = i; j <n; j++) {


                swap(num,i,j);
            if (((i+1)%num[i]==0)||(num[i]%(i+1)==0)){
                beauty(num,i+1,n,c+1);
                swap(num,i,j);
            } else swap(num,i,j);
//            else {
//                swap(num,i,j);
//                beauty(num,i+1,n,c);
//                swap(num,i,j);
//            }
        }
    }
    static int[]swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        return nums;
    }
}
