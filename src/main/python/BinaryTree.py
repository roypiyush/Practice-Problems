#!/usr/bin/python3.4

# -*- coding: utf-8 -*-

import sys

"""
Created on Sat Jan 14 21:19:09 2017

@author: piyush
"""


class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


def in_order(nd):
    if nd is None:
        return
    in_order(nd.left)
    sys.stdout.write(str(nd.val) + " ")
    in_order(nd.right)
        

node = Node(10)
node.left = Node(5)
node.right = Node(15)
node.left.left = Node(1)
node.left.right = Node(8)
node.right.left = Node(12)
node.right.right = Node(17)

in_order(node)
print("")
