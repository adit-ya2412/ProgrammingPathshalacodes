package com.ac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class topandbottomviewoftree {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(9);
        root.left.right = new Node(1);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(3);
        root.left.right.right.right = new Node(7);
        System.out.println(topview(root));
        System.out.println(bottomview(root));
    }

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    static ArrayList<Integer> topview(Node root) {
        Queue<Nodewithflag> q = new LinkedList<>();
        q.add(new Nodewithflag(root, 0));
        Nodewithflag temp;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (!q.isEmpty()) {
            temp = q.poll();
            min = Math.min(min, temp.flag);
            max = Math.max(max, temp.flag);
            if (!map.containsKey(temp.flag)) {
                map.put(temp.flag, temp.node.data);
            }
            if (temp.node.left != null) q.add(new Nodewithflag(temp.node.left, temp.flag - 1));
            if (temp.node.right != null) q.add(new Nodewithflag(temp.node.right, temp.flag + 1));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

    static ArrayList<Integer> bottomview(Node root) {
        Queue<Nodewithflag> q = new LinkedList<>();
        q.add(new Nodewithflag(root, 0));
        Nodewithflag temp;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (!q.isEmpty()) {
            temp = q.poll();
            min = Math.min(min, temp.flag);
            max = Math.max(max, temp.flag);
            if (!map.containsKey(temp.flag)) {
                map.put(temp.flag, temp.node.data);
            } else {
                map.put(temp.flag, temp.node.data);
            }
            if (temp.node.left != null) q.add(new Nodewithflag(temp.node.left, temp.flag - 1));
            if (temp.node.right != null) q.add(new Nodewithflag(temp.node.right, temp.flag + 1));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }
}
