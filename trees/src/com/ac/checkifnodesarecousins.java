package com.ac;

public class checkifnodesarecousins {
    public static void main(String[] args) {
        Node root=new Node(25);
        root.left=new Node(19);
        root.right=new Node(28);
        root.left.left=new Node(4);
        root.left.right=new Node(27);
        root.left.left.left=new Node(17);
        root.left.left.right=new Node(20);
        root.right.left=new Node(6);
        root.right.right=new Node(9);
        int a=6;
        int b=4;
        System.out.println(iscousins(root,a,b));
    }
    static boolean iscousins(Node root,int a,int b){
        if (root.left==null&&root.right==null)return false;
        if ((root.left!=null&&root.left.data==a)&&(root.right!=null&&root.right.data==b))return false;
        levelandparent lf=check(root.left,a,2);
        if (lf.level==-1){
            lf=check(root.right,a,2);
        }
        levelandparent rf=check(root.left,b,2);
        if (rf.level==-1){
            rf=check(root.right,b,2);
        }
        if (lf.level==-1||rf.level==-1)return false;
        return lf.level== rf.level&&lf.parent!= rf.parent;
    }
    static levelandparent check(Node root,int key,int lev){

        if (root==null)return new levelandparent(-1,-1);
        if (root.left!=null&&root.left.data==key)return new levelandparent(lev+1,root.data);
        if (root.right!=null&&root.right.data==key)return new levelandparent(lev+1,root.data);
        levelandparent lf=check(root.left,key,lev+1);
        levelandparent rf=check(root.right,key,lev+1);
        if (lf.level==-1&&rf.level==-1)return lf;
        else if (lf.level==-1)return rf;
        else return lf;
    }
}
class  levelandparent{
    int level;
    int parent;
    levelandparent(int level,int parent){
        this.level=level;
        this.parent=parent;
    }
}
