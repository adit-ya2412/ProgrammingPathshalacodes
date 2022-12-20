package com.ac;

import java.util.*;

public class HauffmanEncoding {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int[]f=new int[s.length()];
        for (int i = 0; i <s.length() ; i++) {
            f[i]=sc.nextInt();
        }
        System.out.println(huffmanCodes(s,f,s.length()));

    }
    static ArrayList<String>huffmanCodes(String S,int[]f,int N){
        PriorityQueue<nodes>queue=new PriorityQueue<>(new Comparator<nodes>(){
            @Override
            public int compare(nodes o1,nodes o2){
                if (o1.freq==o2.freq)return 1;
                return o1.freq-o2.freq;
            }
        });
        for (int i = 0; i <N ; i++) {
            queue.add(new nodes(null,null,S.charAt(i),f[i]));
        }
        while (queue.size()!=1){
            nodes l=queue.poll();
            nodes r=queue.poll();
            nodes temp=new nodes(l,r,' ', l.freq+ r.freq);
            queue.add(temp);
        }
        ArrayList<String>ans=new ArrayList<>();
        dfs(queue.poll(),ans,"");
        return ans;
    }
    static void dfs(nodes n,List<String>answer,String temp){
        if (n==null)return;
        if (n.left==null&&n.right==null){
           // temp.append(n.ch);
            answer.add(temp.toString());
            //temp.deleteCharAt(temp.length()-1);
            return;
        }

        dfs(n.left,answer,temp+'0');
        dfs(n.right,answer,temp+'1');

    }
}
class nodes{
    nodes left;
    nodes right;
    char ch;
    int freq;
    nodes(nodes l,nodes right,char ch,int freq){
        this.left=l;
        this.right=right;
        this.ch=ch;
        this.freq=freq;
    }
}
