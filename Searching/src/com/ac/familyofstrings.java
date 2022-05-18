package com.ac;

public class familyofstrings {
    public static void main(String[] args) {
        //System.out.println(fastexponentiation(2,3));
        System.out.println(kthcharc(3,4));
     }
     static String kthcharc(int n,int i){
        int bit=0;
        long lengthofstring=fastexponentiation(2,n+1);
         long l=0;
         long h=lengthofstring-2;
         while (l<=h){
             long mid=l+(h-l)/2;
             if (mid>i){
                 h=mid-1;
             }else if (mid<i){
                 bit=1;
                 l=mid+1;
             }else {
                 return ""+bit;
             }
         }
         return "}";
     }
    static long fastexponentiation(int n,int i){
        if (i==0)return 1;
        long ans=fastexponentiation(n,Math.abs(i/2));
        if (i%2==0){
            return ans*ans;
        }else {
            return ans*ans*n;
        }
    }
}
