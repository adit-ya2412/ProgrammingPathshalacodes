package com.ac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class fractionalKnapsack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Item[]arr=new Item[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=new Item(sc.nextInt(),sc.nextInt());
        }
        int w=sc.nextInt();
        System.out.println(fractionalKnapsack(w,arr,n));
    }
    static double fractionalKnapsack(int W,Item[]arr,int n){
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return (o2.value*o1.weight)-(o1.value*o2.weight);
            }
        });
        double ans=0;
        for (int i = 0; i <n ; i++) {
            if (arr[i].weight<=W){
                ans+=arr[i].value;
                W-=arr[i].weight;
            }else {
                double r=(W*arr[i].value*1.0)/arr[i].weight;
                ans+=r;
                break;
            }
        }
        return ans;
    }
}
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
