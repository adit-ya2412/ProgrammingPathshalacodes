package com.ac;

class findprimeslessthann {
    public static void main(String[] args) {
        System.out.println(countPrimes(3));
    }
    static int countPrimes(int n) {
        int[]arr=new int[n+1];
        return generatesiev(arr);
    }
      static int generatesiev(int[]arr){
        //List<Integer>ans=new ArrayList<>();
        for (int i = 2; i <arr.length ; i++) {
            arr[i]=1;
        }
        for (int i = 2; i*i <arr.length ; i++) {
            if (arr[i]==1){
                for (int j = i; j*i <arr.length ; j++) {
                    arr[i*j]=0;
                }
            }
        }
          int count=0;
        for (int i = 2; i <arr.length-1 ; i++) {
            if (arr[i]==1)count++;
        }
        return count;
    }
}