package com.company.topinterview.mediumcollection.trees;

import com.company.thirtydaychallenge.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BoundaryTraversal {
    private static boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }

    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> op = new ArrayList<>();
        if (A == null) {
            return op;
        }

        Queue<VN> q = new LinkedList<>();
        q.offer(new VN(A, 0));

        ArrayList<Integer> f = new ArrayList<>();
        ArrayList<VN> s = new ArrayList<>();
        Stack<Integer> t = new Stack<>();

        while (!q.isEmpty()) {
            int count = q.size() - 1;
            VN first = q.poll();
            if (first.t.left != null)
                q.offer(new VN(first.t.left, first.d - 1));
            if (first.t.right != null)
                q.offer(new VN(first.t.right, first.d + 1));
            f.add(first.t.val);

            if (isLeaf(first.t)) {
                while (count > 0 && isLeaf(q.peek().t)) {
                    VN node = q.poll();
                    if (node.t.left != null)
                        q.offer(new VN(node.t.left, node.d - 1));
                    if (node.t.right != null)
                        q.offer(new VN(node.t.right, node.d + 1));
                    f.add(node.t.val);
                    count--;
                }
            }

            while (count > 0) {
                VN node = q.poll();
                if (node.t.left != null)
                    q.offer(new VN(node.t.left, node.d - 1));
                if (node.t.right != null)
                    q.offer(new VN(node.t.right, node.d + 1));
                if (isLeaf(node.t))
                    s.add(node);
                else if (count == 1)
                    t.push(node.t.val);
                count--;
            }
        }

        s.sort((VN v1, VN v2) -> (v1.d - v2.d));
        for (VN node : s)
            f.add(node.t.val);
        while (!t.isEmpty())
            f.add(t.pop());
        return f;
    }
}


class VN {
    TreeNode t;
    int d;

    VN() {

    }

    VN(TreeNode t, int d) {
        this.t = t;
        this.d = d;
    }

}
