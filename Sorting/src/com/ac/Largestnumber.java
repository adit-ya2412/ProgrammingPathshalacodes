package com.ac;

import java.util.*;

public class Largestnumber {
    public static void main(String[] args) {
      int[]arr={3,30,34,5,9};
        System.out.println(sortandmakelargest(arr));
    }

    static String sortandmakelargest(int[] arr) {
        List<Integer>wrapper=new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return arr[index];
            }

            @Override
            public int size() {
                return arr.length;
            }
            @Override
            public Integer set(int index, Integer element) {
                int v = arr[index];
                arr[index] = element;
                return v;
            }
        };
        Collections.sort(wrapper,new comparebydigits());
        String ans="";
        for (Integer obj:wrapper) {
            ans+=obj.toString();
        }
        return ans;
    }

}

class comparebydigits implements Comparator<Integer>{
    @Override
    public int compare  (Integer o1,Integer o2){
        String aa=o1.toString();
        String bb=o2.toString();
        String firstcase=aa+bb;
        String secondcase=bb+aa;
        return secondcase.compareTo(firstcase);
    }
}
