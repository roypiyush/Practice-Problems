#!/usr/bin/python3.4

# -*- coding: utf-8 -*-
"""
Created on Sat Jan 14 21:19:09 2017

@author: piyush
"""

class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


def inorder(Node):
    if(Node == None):
        return;
    inorder(Node.left);
    print(str(Node.val) + " ", end="")
    inorder(Node.right)
        

node = Node(10)
node.left = Node(5)
node.right = Node(15)
node.left.left = Node(1)
node.left.right = Node(8)
node.right.left = Node(12)
node.right.right = Node(17)

inorder(node)
print("")
