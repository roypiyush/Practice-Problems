package com.hackerearth;


public class SelfBalancingTree {

    private int val;
    private SelfBalancingTree left;
    private SelfBalancingTree right;
    private int ht;

    public SelfBalancingTree(int val) {
        this.val = val;
        this.ht = 1;
    }

    public static void main(String[] args) {
        SelfBalancingTree root = new SelfBalancingTree(1);
        root.insert(root, 2);


    }

    @Override
    public String toString() {
        return "SelfBalancingTree [val=" + val + ", left=" + left + ", right=" + right + ", ht=" + ht + "]";
    }

    public SelfBalancingTree insert(SelfBalancingTree node, int val) {
        if (node == null) {
            SelfBalancingTree tree = new SelfBalancingTree(val);
            return tree;
        }

        if (val < node.val) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }
        node.ht += 1;

        int lht = node.left.ht;
        int rht = node.right.ht;

        if (lht - rht >= 2) {
            // Right Tree height is greater than left tree

            // 1. Left right case
            SelfBalancingTree l = node.left;
            int lt = l.left.ht - l.right.ht;
            if (lt == -1) { // Convert it to left left case

                SelfBalancingTree rt = l.right;
                l.right = rt.left;
                rt.left = l;
                node.left = rt;

            }

            // 2. Left Left case
            l = node.left;
            node.left = l.right;
            l.right = node;
            return l;
        } else if (lht - rht <= -2) {
            // 1. right left case
            SelfBalancingTree r = node.right;
            int rt = r.left.ht - r.right.ht;
            if (rt == 1) { // Convert it to right right case
                SelfBalancingTree lt = r.left;
                r.left = lt.right;
                lt.right = r;
                node.right = lt;
            }
            // 2. right right case
            r = node.right;
            node.right = r.left;
            r.left = node;
            return r;
        }

        return node;
    }

}
