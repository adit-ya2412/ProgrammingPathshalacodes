package com.ac;

import java.util.ArrayList;
import java.util.List;

public class pairsviolatingBST {
    public static void main(String[] args) {
        Node root=new Node(50);
        root.left=new Node(30);
        root.right=new Node(60);
        root.left.left=new Node(20);
        root.left.right=new Node(25);
        root.right.left=new Node(10);
        root.right.right=new Node(40);
        System.out.println(pairs(root));
    }
    static int cnt;
    static List<Integer>list=new ArrayList<>();
    static int pairs(Node root){
        traverse(root);
        cnt=0;
        inversioncnt(list,0,list.size()-1);
        return cnt;
    }
    static void inversioncnt(List<Integer>list,int i,int j){
        if (i==j)return;
        int mid=(i+(j-i)/2);
        inversioncnt(list,i,mid);
        inversioncnt(list,mid+1,j);
        merge(list,i,mid,j);
    }
    static void merge(List<Integer>list,int st1,int mid,int end1){
        int i=st1;
        int j=mid+1;
        int k=0;
        List<Integer>temp=new ArrayList<>(end1-st1+1);
        for (;i<=mid&&j<=end1;){
            if (list.get(i)<=list.get(j)){
                temp.add(k,list.get(i));
                i++;
                k++;
            }else {
                cnt+=(mid-i+1);
                temp.add(k,list.get(j));
                j++;
                k++;
            }
        }
        while (i<=mid){
            temp.add(k++,list.get(i++));
        }
        while (j<=end1){
            temp.add(k++,list.get(j++));
        }
        for (int l=0;l<temp.size();l++){
            list.set(l+st1,temp.get(l));
        }
    }
    static void traverse(Node root){
        if (root==null)return;
        traverse(root.left);
        list.add(root.data);
        traverse(root.right);
    }
}
