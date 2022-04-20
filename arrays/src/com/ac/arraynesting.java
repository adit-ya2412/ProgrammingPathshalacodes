package com.ac;

public class arraynesting {
    public static void main(String[] args) {
    //int[]n={5,4,0,3,1,6,2};
        int[]n={0,1,3,2};
        System.out.println(longest(n));
    }
    static int longest(int[]arr){
        int counter=Integer.MIN_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]>=0){
                int c=0;
                int ind=arr[i];
                arr[i]=(-(ind+1));
                c++;
                while (ind!=i){
                    int temp=arr[ind];
                    arr[ind]=(-(temp+1));
                    c++;
                    ind=temp;
                }
                if (c>counter)counter=c;
            }
        }
        return counter;
    }
}
