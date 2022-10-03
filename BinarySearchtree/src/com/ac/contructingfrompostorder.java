package com.ac;

public class contructingfrompostorder {
    public static void main(String[] args) {
        int[]arr={1,7,5,50,40,10};
        Node ans=constructTree(arr,arr.length);
    }
    static Node constructTree(int[]post,int n){
          idx=n-1;
          return create(post,Integer.MAX_VALUE,Integer.MIN_VALUE);

    }
    static int idx;
    static Node create(int[]post,int up,int lb){
        if (idx>=0&&(post[idx]<up&&post[idx]>lb)){
          Node root=new Node(post[idx]);
          idx--;
          root.right=create(post,up,root.data);
          root.left=create(post,root.data,lb);
          return root;
        }
        return null;
    }
}
