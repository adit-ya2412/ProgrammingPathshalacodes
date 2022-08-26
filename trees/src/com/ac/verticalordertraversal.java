package com.ac;
import java.util.*;
public class verticalordertraversal {
    public static void main(String[] args) {
        Node root=new Node(5);
        root.left=new Node(6);
        root.right=new Node(8);
        root.left.left=new Node(11);
        root.left.right=new Node(7);
        root.left.left.right=new Node(12);
        root.right.right=new Node(9);
        root.right.right.left=new Node(10);
        System.out.println(printvertical2(root));
    }
    static int min=Integer.MAX_VALUE;
    static int max=Integer.MIN_VALUE;
    static ArrayList<Integer>printvertical2(Node root){
        Queue<Nodewithflag>q=new LinkedList<>();
        q.add(new Nodewithflag(root,0));
        HashMap<Integer,List<Integer>>map=new HashMap<>();
        Nodewithflag temp;
        while (!q.isEmpty()){
            temp=q.poll();
            min=Math.min(temp.flag,min);
            max=Math.max(max,temp.flag);
            if (map.containsKey(temp.flag)){
                map.get(temp.flag).add(temp.node.data);
            }else {
                List<Integer>t=new ArrayList<>();
                        t.add(temp.node.data);
                map.put(temp.flag,t);
            }
            if (temp.node.left!=null)q.add(new Nodewithflag(temp.node.left,temp.flag-1));
            if (temp.node.right!=null)q.add(new Nodewithflag(temp.node.right,temp.flag+1));
        }
        ArrayList<Integer>ans=new ArrayList<>();
        int i=min,j=max;
        while (i<=j){
            List<Integer>templist=map.get(i);
            for (int t:templist){
                ans.add(t);
            }
            i++;
        }
        return ans;
    }
    static void printvertcal1(Node root){
        if (root==null) return;
        List<nodewithlevandhd>ans=new ArrayList<>();
        traverse(root,ans,0,0);
        Collections.sort(ans,new sortbyhdandlev());
        for (nodewithlevandhd n1:ans){
            System.out.print(n1.node.data+","+n1.lev+","+n1.hd+" -->");
        }

    }
    static void traverse(Node root,List<nodewithlevandhd>ans,int lev,int horizontaldistance){
        if (root==null)return;
        ans.add(new nodewithlevandhd(root,lev,horizontaldistance));
        traverse(root.left,ans,lev+1,horizontaldistance-1);
        traverse(root.right,ans,lev+1,horizontaldistance+1);
    }
}
class sortbyhdandlev implements Comparator<nodewithlevandhd>{
    @Override
    public int compare(nodewithlevandhd n1,nodewithlevandhd n2){
        if (n1.hd!= n2.hd)return Integer.compare(n1.hd,n2.hd);
        return Integer.compare(n1.lev,n2.lev);
    }

}
class nodewithlevandhd{
    Node node;
    int lev;
    int hd;
    nodewithlevandhd(Node node,int level,int horizontaldistance){
        this.node=node;
        this.lev=level;
        this.hd=horizontaldistance;
    }
}

class Nodewithflag {
    Node node;
    int flag;

    Nodewithflag(Node node, int flag) {
        this.node = node;
        this.flag = flag;
    }
}