package com.ac;

public class kthsmallestelement {
    public static void main(String[] args) {
     int[]arr={50,10,10,30,40,20,40,70};
        System.out.println(smallest(arr,5));
    }
    static int smallest(int []arr,int k){
        for (int i = 0; i <arr.length ; i++) {
            int elementchoosen=arr[i];
            int freqofsmallernummebrs=0;
            int freqofsimillarnumbers=0;
            for (int j = 0; j <arr.length ; j++) {
                if (arr[j]==elementchoosen)freqofsimillarnumbers++;
                else if (arr[j]<elementchoosen)freqofsmallernummebrs++;
            }
            int tol=freqofsimillarnumbers+freqofsmallernummebrs;
            if (tol>=k&&freqofsmallernummebrs<k)return arr[i];
        }
        return -1;
    }
}
