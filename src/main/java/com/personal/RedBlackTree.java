package com.personal;

enum Color {
    RED,
    BLACK;
}

class RBNode {
    public int key;
    public Color color;
    public RBNode left;
    public RBNode right;
    public RBNode parent;
}

public class RedBlackTree {
    private static final RBNode NIL = new RBNode();
    private RBNode ROOT;

    public RedBlackTree() {
        NIL.color = Color.BLACK;
        ROOT = NIL;
    }

    private void leftRotate(RBNode node) { // TODO Verify Correctness
        RBNode right = node.right;
        node.right = right.left;
        right.parent = node.parent;
        if (node.parent == NIL) {
            ROOT = right;
        } else if (node == node.parent.left) {
            node.parent.left = right;
        } else {
            node.parent.right = right;
            right.left = node;
            node.parent = right;
        }
    }

    private void rightRotate(RBNode node) { // TODO Verify Correctness
        RBNode left = node.left;
        node.left = left.right;
        left.parent = node.parent;
        if (node.parent == NIL) {
            ROOT = left;
        } else if (node == node.parent.left) {
            node.parent.right = left;
        } else {
            node.parent.left = left;
            left.left = node;
            node.parent = left;
        }
    }


    public void insert(RBNode newNode) {
        RBNode parent = NIL;
        RBNode currentNode = ROOT;
        while (currentNode != NIL) {
            parent = currentNode;
            if (newNode.key < currentNode.key) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        newNode.parent = parent;
        if (parent == NIL) {
            ROOT = newNode;
        } else if (newNode.key < currentNode.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        newNode.left = NIL;
        newNode.right = NIL;
        newNode.color = Color.RED;
        fixInsert(newNode);
    }

    private void fixInsert(RBNode z) {
        while (z.color == Color.RED) {
            if (z.parent.parent.left == z.parent) { // If z's parent is left child
                RBNode uncle = z.parent.parent.right;
                if (uncle.color == Color.RED) { // Case 1
                    // Change color of z's parent, uncle, grandparent
                    uncle.color = Color.BLACK;
                    z.parent.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                } else {
                    if (z.parent.right == z) {
                        z = z.parent; // Move the pointer up
                        leftRotate(z);
                    }
                    z.parent.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    rightRotate(z.parent.parent);
                }
            } else { // If z's parent is right child
                RBNode uncle = z.parent.parent.left;
                if (uncle.color == Color.RED) { // Case 1
                    // Change color of z's parent, uncle, grandparent
                    uncle.color = Color.BLACK;
                    z.parent.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                } else {
                    if (z.parent.left == z) {
                        z = z.parent; // Move the pointer up
                        rightRotate(z);
                    }
                    z.parent.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    leftRotate(z.parent.parent);
                }
            }
        }
        ROOT.color = Color.BLACK;
    }

    private void transplant(RBNode u, RBNode v) {
        if (u.parent == NIL) {
            ROOT = v;
        } else if (u.parent.left == u) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        if (v != null) {
            v.parent = u.parent;
        }
    }

}