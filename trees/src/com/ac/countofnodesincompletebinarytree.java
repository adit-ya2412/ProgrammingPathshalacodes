package com.ac;

import java.util.HashMap;

public class countofnodesincompletebinarytree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        System.out.println(countofnodes(root));
        System.out.println(countnodes(root));
    }
    static int countnodes(TreeNode root){
        if (root==null)return 0;
        HashMap<Boolean,Integer>left=checkifperfect(root.left);
        HashMap<Boolean,Integer>right=checkifperfect(root.right);
        int leftht=0,rightht=0;
        if (left.containsKey(true)){
            leftht= (int) (Math.pow(2,left.get(true))-1);
        }else {
            leftht+=countofnodes(root.left);
        }
        if (right.containsKey(true)){
            rightht= (int) (Math.pow(2,right.get(true))-1);
        }else {
            rightht+=countofnodes(root.right);
        }
        return 1+leftht+rightht;

    }
    static HashMap<Boolean,Integer>checkifperfect(TreeNode root){
        TreeNode temp=root;
        int hleft=0;
        while (temp!=null){
            temp=temp.left;
            hleft++;
        }
        int hright=0;
        temp=root;
        while (temp!=null){
            temp=temp.right;
            hright++;
        }
        HashMap<Boolean,Integer>map=new HashMap<>();
        if (hleft==hright){

            map.put(true,hleft);
        }else {
            map.put(false,-1);
        }
        return map;
    }
    static int countofnodes(TreeNode root){
        if (root==null)return 0;
        int ht=get_height(root);
        int max_leavecnt=max_nodes(2,ht-1);
        int low=1;
        int high=max_leavecnt;
        int ans=0;
        while (low<=high){
            int mid=low+(high-low)/2;
            boolean flag=isnull(root,max_leavecnt,mid);
            if (flag)high=mid-1;
            else {
                if (isnull(root,max_leavecnt,mid+1)){
                    ans=mid;
                    break;
                }else low=mid+1;
            }
        }
        return ans+max_leavecnt-1;
    }
    static boolean isNull(TreeNode root,int noofnodes,int mid){
        if (mid>noofnodes)return true;
        int l=1;int h=noofnodes;
        while (h>l){
            int m=l+(h-l)/2;
            if (mid<=m){
                root=root.left;
                h=m;
            }
            else{
                root=root.right;
                l=m+1;
            }

        }
        return root==null;
    }
    static boolean isnull(TreeNode root,int max_nodes,int node){
        if(node>max_nodes)return true;
        int l=1;
        int h=max_nodes;
        while(h>l){
            int mid=l+(h-l)/2;
            if(node<=mid){
                root=root.left;
                h=mid;
            }
            else {
                root=root.right;
                l=mid+1;
            }
        }
        return root==null;
    }
    static int max_nodes(int base,int ht){
        if(ht==0)return 1;
        int h=max_nodes(base,ht/2);
        if (ht%2==0)return h*h;
        else return h*h*base;
    }
    static int get_height(TreeNode root){
        int ans=0;
        while (root!=null){
            root=root.left;
            ans++;
        }
        return ans;
    }

}

