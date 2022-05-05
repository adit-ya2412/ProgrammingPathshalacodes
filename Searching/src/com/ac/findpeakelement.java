package com.ac;

public class findpeakelement {
    public static void main(String[] args) {
        //int[]ar={1,20,15,14,16,28,90,72};
        int[]ar={20,1,1,1,1};
        System.out.println(findpeak(ar));
    }
    static int findpeak(int[]arr){
        int l=0;
        int h=arr.length-1;
        while (l<=h){
            int mi=l+(h-l)/2;
            if (mi!=arr.length-1&&arr[mi]<arr[mi+1]){
                l=mi+1;
            }else {
                if (mi==arr.length-1)return mi;
                if (mi!=0&&arr[mi-1]<arr[mi])return mi;
                if (mi==0)return mi;
                h=mi-1;
            }
        }
        return -1;
    }
}
