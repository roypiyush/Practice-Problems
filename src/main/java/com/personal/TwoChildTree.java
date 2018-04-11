/**
 *
 */
package com.personal;

/**
 * @author piyush
 */

class BinaryNode {

    int data;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(int data) {
        this.data = data;
    }

}


public class TwoChildTree {

    static BinaryNode removeSingleChild(BinaryNode root) {

        if (root == null) return null;

        root.left = removeSingleChild(root.left);
        root.right = removeSingleChild(root.right);

        if (root.left == null && root.right != null) {
            return root.right;
        } else if (root.left != null && root.right == null) {
            return root.left;
        } else {
            return root;
        }

    }

    static void inorder(BinaryNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        BinaryNode root = new BinaryNode(10);
        root.left = new BinaryNode(5);
        root.right = new BinaryNode(15);
        root.left.right = new BinaryNode(7);
        root.left.right.left = new BinaryNode(8);
        root.left.right.right = new BinaryNode(0);

        root = removeSingleChild(root);
        inorder(root);
    }

}
