package com.personal;

import java.util.LinkedList;

public class BinaryTree {

    static int max = 0;
    int value;
    int level;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
        this.value = value;
    }

    static void levelOrder(LinkedList<BinaryTree> queue) {
        int cur = 1;
        while (queue.size() != 0) {
            BinaryTree item = queue.poll();
            if (item.level > cur) {
                cur = item.level;
                System.out.println();
            }
            System.out.print(item.value + " ");
            if (item.left != null) {
                item.left.level = item.level + 1;
                queue.offer(item.left);
            }
            if (item.right != null) {
                item.right.level = item.level + 1;
                queue.offer(item.right);
            }
        }
    }

    static void spiralLevelOrder(LinkedList<BinaryTree> queue) {
        int cur = 1;
        LinkedList<BinaryTree> even = new LinkedList<>();
        LinkedList<BinaryTree> odd = new LinkedList<>();
        while (queue.size() != 0) {
            BinaryTree item = queue.poll();
            if (item.level > cur) {
                cur = item.level;
                System.out.println();
            }
            if (item.level % 2 != 0) {
                System.out.print(item.value + " ");
            } else {
                System.out.print(even.pop().value + " ");
            }
            if (item.left != null) {
                item.left.level = item.level + 1;
                queue.offer(item.left);
                if (item.left.level % 2 == 0) {
                    even.push(item.left);
                }
            }
            if (item.right != null) {
                item.right.level = item.level + 1;
                queue.offer(item.right);
                if (item.right.level % 2 == 0) {
                    even.add(item.right);
                }
            }
        }
    }

    static void leftSide(BinaryTree root, int cur) {
        if (root == null)
            return;
        if (cur > max) {
            max = cur;
            System.out.println(root.value);
        }
        leftSide(root.left, cur + 1);
        leftSide(root.right, cur + 1);
    }

    static void inorder(BinaryTree root, LinkedList<BinaryTree> inorder) {
        if (root == null) {
            return;
        }
        inorder(root.left, inorder);
        inorder.add(root);
        inorder(root.right, inorder);
    }

    static void preorder(BinaryTree root, LinkedList<BinaryTree> preorder) {
        if (root == null) {
            return;
        }
        preorder.add(root);
        preorder(root.left, preorder);
        preorder(root.right, preorder);
    }

    static int findElement(BinaryTree[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (key == array[i].value)
                return i;
        }
        return -1;
    }

    static BinaryTree construct(BinaryTree[] inorder, int i, int j, LinkedList<BinaryTree> preorder) {
        if (i > j)
            return null;
        int k = preorder.poll().value;
        BinaryTree node = new BinaryTree(k);
        int index = findElement(inorder, k);
        node.left = construct(inorder, i, index - 1, preorder);
        node.right = construct(inorder, index + 1, j, preorder);
        return node;
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(8);
        root.level = 1;
        root.left = new BinaryTree(5);
        root.right = new BinaryTree(4);
        root.left.left = new BinaryTree(9);
        root.left.right = new BinaryTree(7);
        root.left.right.left = new BinaryTree(1);
        root.left.right.right = new BinaryTree(12);
        root.left.right.right.right = new BinaryTree(2);
        root.right.right = new BinaryTree(11);
        root.right.right.left = new BinaryTree(3);

        LinkedList<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        spiralLevelOrder(queue);
        max = 0;
        System.out.println("\n");
        leftSide(root, 1);

        LinkedList<BinaryTree> inorder = new LinkedList<>();
        inorder(root, inorder);
        LinkedList<BinaryTree> preorder = new LinkedList<>();
        preorder(root, preorder);
        System.out.println(inorder);
        System.out.println(preorder);
        BinaryTree[] inorderArray = inorder.toArray(new BinaryTree[inorder.size()]);
        BinaryTree newTree = construct(inorderArray, 0, inorder.size() - 1, preorder);
        inorder.clear();
        inorder(newTree, inorder);
        System.out.println(inorder);
    }

    @Override
    public String toString() {
        return value + "";
    }
}
