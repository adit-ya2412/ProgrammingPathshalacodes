package com.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Allbinarytrees {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<List<TreeNode>>ans=generate(n);
        System.out.println(ans.get(n).size());
    }
    static List<List<TreeNode>>generate(int n){
        List<List<TreeNode>>ans=new ArrayList<>();

        List<TreeNode>nul=new ArrayList<>();
        nul.add(new TreeNode());
        ans.add(nul);
        for (int i = 1; i <=n ; i++) {
            List<TreeNode>temp=new ArrayList<>();
            for (int j = 0; j <i ; j++) {
                List<TreeNode>lst=ans.get(j);
                List<TreeNode>rst=ans.get(i-1-j);
                for (int k = 0; k <lst.size() ; k++) {
                    for (int l = 0; l <rst.size() ; l++) {
                        temp.add(new TreeNode(0,lst.get(k),rst.get(l)));
                    }
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
