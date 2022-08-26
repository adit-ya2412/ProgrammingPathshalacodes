package com.ac;

import java.util.*;

public class mostfrequentsubtreesum {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(4);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(5);
        root.left.right=new TreeNode(2);
        root.right.left=new TreeNode(8);
        root.right.right=new TreeNode(0);
        System.out.println(Arrays.toString(maxfreq(root)));
    }
    static int[]maxfreq(TreeNode root){
        if (root.left==null&&root.right==null)return new int[]{root.val};
        int sum=mapfreq(root);
        //freq.put(sum,freq.getOrDefault(sum,0)+1);
        int maxfreq=Integer.MIN_VALUE;
        for(int freqq:freq.values()){
            maxfreq=Math.max(maxfreq,freqq);
        }
        List<Integer>values=new ArrayList<>();
        for (Map.Entry<Integer,Integer>is:freq.entrySet()){
            if (is.getValue()==maxfreq){
                values.add(is.getKey());
            }
        }
       int []ans=new int[values.size()];
        for (int i = 0; i <values.size() ; i++) {
            ans[i]=values.get(i);
        }
        return ans;

    }
    static HashMap<Integer,Integer>freq=new HashMap<>();
    static int mapfreq(TreeNode root){
        if (root==null)return 0;
        int left=mapfreq(root.left);
        int right=mapfreq(root.right);
        int sum=root.val+left+right;
        freq.put(sum,freq.getOrDefault(sum,0)+1);
        return sum;
    }
}
