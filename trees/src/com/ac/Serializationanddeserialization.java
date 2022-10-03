package com.ac;

import static com.ac.prunebinarytree.print;

public class Serializationanddeserialization {
    public static void main(String[] args) {
        TreeNode root =new TreeNode(111111);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(5);
        String ser=serialize(root);
        TreeNode ans=deserialize(ser);
        print(ans);
    }

    static String serialize(TreeNode root){
         if (root==null)return "N";
         StringBuilder s=new StringBuilder();
         s.append(root.val);
         s.append(",");
         StringBuilder left=new StringBuilder();
         left.append(serialize(root.left));
         //left.append(",");
         StringBuilder right=new StringBuilder();
          right.append(serialize(root.right));
          //right.append(",");
         s.append(left);
         s.append(",");
         s.append(right);
         return s.toString();
    }
    static int idx=0;
    static TreeNode deserialize(String data) {
        String[]arr=(data.split(","));
        return buildtree(arr);
    }
    static TreeNode buildtree(String[]data){
        if (data[idx].equals("N")){
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(data[idx]));
        idx++;
        root.left=buildtree(data);
        root.right=buildtree(data);
        return root;
    }
}
