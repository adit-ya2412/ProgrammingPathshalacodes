package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class advantageshuffle {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr1=new int[n];
        int[]arr2=new int[n];
        String[]ele1=(in.readLine().trim()).split("\\s+");
        String[]ele2=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr1[i]=Integer.parseInt(ele1[i]);
            arr2[i]=Integer.parseInt(ele2[i]);
        }
       // System.out.println(Arrays.toString(advantage(arr1,arr2)));
    }
    //this approach gives TLE on 66th case out of 67.
//    static int[]advantage(int[]nums1,int[]nums2){
//        if (nums1.length==1)return new int[]{nums1[0]};
//        List<pairsandindex>ls=new ArrayList<>();
//        for (int i = 0; i <nums2.length ; i++) {
//            ls.add(new pairsandindex(nums2[i],i ));
//        }
//        Arrays.sort(nums1);
//        Collections.sort(ls,new comparebyindex());
//        int[]temp=new int[nums1.length];
//        int i=0,j=0;
//        while (j<nums2.length){
//            int ind=binarysearch(nums1,0,ls.get(j).value);
//            if (ind<nums1.length){
//                temp[ls.get(j).index]=nums1[ind];
//                nums1[ind]=-1;
//            }
//            j++;
//        }
//        for (int k = 0; k <temp.length ; k++) {
//            if (temp[k]==0){
//                for (int l = 0; l <nums1.length ; l++) {
//                    if (nums1[l]!=-1){
//                        temp[k]=nums1[l];
//                        nums1[l]=-1;
//                        break;
//                    }
//                }
//            }
//        }
//    return temp;
//    }
//    static int binarysearch(int[]arr,int st,int key){
//        int l=st;
//        int h=arr.length-1;
//        while (l<=h){
//            int mid=l+(h-l)/2;
//            if (arr[mid]>key){
//                h--;
//            }else {
//                l++;
//            }
//        }
//        return l;
//    }

}
class pairsandindex{
int value;
int index;
pairsandindex(int value,int index){
    this.value=value;
    this.index=index;
}
}
class comparebyindex implements Comparator<pairsandindex>{
    @Override
    public int compare(pairsandindex o1,pairsandindex o2){
        return Integer.compare(o1.value,o2.value);
    }
}
