package com.personal;

enum Color {
    RED,
    BLACK
}

class RBNode {
    public Integer key;
    public Color color;
    public RBNode left;
    public RBNode right;
    public RBNode parent;
    public String toString() {
        return key == null ? "NIL" : String.format("%s %s", key, color);
    }
}

/**
 * Properties of Red Black Tree.
 * <ol>
 *     <li>Every node is either black or red</li>
 *     <li>Root is always black</li>
 *     <li>Every leaf node is NIL and BLACK</li>
 *     <li>If a node is red, then both its children are black</li>
 *     <li>For each node, all simple paths from the node to descendant leaves have same number of black nodes</li>
 * </ol>
 */
public class RedBlackTree {
    private static final RBNode NIL = new RBNode();
    private RBNode ROOT;

    private RedBlackTree() {
        NIL.color = Color.BLACK;
        ROOT = NIL;
    }

    private RBNode leftRotate(RBNode node) {
        RBNode right = node.right;
        node.right = right.left;
        if (right.left != NIL) {
            right.left.parent = node;
        }
        right.parent = node.parent;
        if (node.parent == NIL) {
            ROOT = right;
        } else if (node == node.parent.left) {
            node.parent.left = right;
        } else {
            node.parent.right = right;
        }
        right.left = node;
        node.parent = right;
        return right;
    }

    private RBNode rightRotate(RBNode node) {
        RBNode left = node.left;
        node.left = left.right;
        if (left.right != NIL) {
            left.right.parent = node;
        }
        left.parent = node.parent;
        if (node.parent == NIL) {
            ROOT = left;
        } else if (node == node.parent.left) {
            node.parent.right = left;
        } else {
            node.parent.left = left;
        }
        left.left = node;
        node.parent = left;
        return left;
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
        } else if (newNode.key < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        newNode.left = NIL;
        newNode.right = NIL;
        newNode.color = Color.RED;
        fixInsert(newNode);
    }

    private void fixInsert(RBNode newNode) {
        while (newNode.color == Color.RED) {
            if (newNode.parent.parent == null) { // Need to handle explicitly
                break;
            }
            if (newNode.parent.parent.left == newNode.parent) { // If newNode's parent is left child
                RBNode uncle = newNode.parent.parent.right;
                if (uncle == null) { // Need to handle explicitly
                    break;
                } else if (uncle.color == Color.RED) { // Case 1
                    // Change color of newNode's parent, uncle, grandparent
                    uncle.color = Color.BLACK;
                    newNode.parent.color = Color.BLACK;
                    newNode.parent.parent.color = Color.RED;
                    newNode = newNode.parent.parent;
                } else {
                    if (newNode.parent.right == newNode) {
                        newNode = newNode.parent; // Move the pointer up
                        newNode = leftRotate(newNode);
                    }
                    newNode.parent.color = Color.BLACK;
                    newNode.parent.parent.color = Color.RED;
                    newNode = rightRotate(newNode.parent.parent);
                }
            } else { // If newNode's parent is right child
                RBNode uncle = newNode.parent.parent.left;
                if (uncle == null) { // Need to handle explicitly
                    break;
                } else if (uncle.color == Color.RED) { // Case 1
                    // Change color of newNode's parent, uncle, grandparent
                    uncle.color = Color.BLACK;
                    newNode.parent.color = Color.BLACK;
                    newNode.parent.parent.color = Color.RED;
                    newNode = newNode.parent.parent;
                } else {
                    if (newNode.parent.left == newNode) {
                        newNode = newNode.parent; // Move the pointer up
                        newNode = rightRotate(newNode);
                    }
                    newNode.parent.color = Color.BLACK;
                    newNode.parent.parent.color = Color.RED;
                    newNode = leftRotate(newNode.parent.parent);
                }
            }
        }
        ROOT.color = Color.BLACK;
    }

    @SuppressWarnings("unused")
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

    private static RBNode buildNewNode(int key) {
        RBNode node = new RBNode();
        node.key = key;
        node.color = Color.RED;
        node.left = NIL;
        node.right = NIL;
        node.parent = NIL;
        return node;
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        for (int i = 1; i <= 10; i++)
            tree.insert(buildNewNode(i));
        System.out.println();
    }
}