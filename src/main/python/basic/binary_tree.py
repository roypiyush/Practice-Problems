#!/usr/bin/python3.4

# -*- coding: utf-8 -*-

import sys

"""
Created on Sat Jan 14 21:19:09 2017

@author: piyush
"""


class Node(object):
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.level = 0

    def __str__(self):
        return self.val

    def __repr__(self):
        return 'Value: {} Level: {}'.format(self.val, self.level)


def in_order(nd):
    if nd is None:
        return
    in_order(nd.left)
    sys.stdout.write(str(nd.val) + " ")
    in_order(nd.right)


def in_order_iterative_using_stack(nd):
    if nd is None:
        return
    stack = []
    current_node = nd
    stack.append(current_node)
    current_node = current_node.left
    while len(stack) > 0 or current_node is not None:
        if current_node is not None:
            stack.append(current_node)
            current_node = current_node.left
        else:
            current_node = None if len(stack) == 0 else stack.pop()
            if current_node is not None:
                sys.stdout.write(str(current_node.val) + " ")
                current_node = current_node.right


def find_diameter(root):
    if root is None:
        return 0, 0

    lh, max_left = find_diameter(root.left)
    rh, max_right = find_diameter(root.right)

    max_result = max(lh + rh + 1, max(max_left, max_right))
    return max(lh, rh) + 1, max_result


def level_order_traversal(root, queue, cur, max_level):
    if root is None or len(queue) == 0:
        return

    item = queue.pop(0)
    if item.level > max_level:
        print()
        max_level = item.level

    sys.stdout.write('{} '.format(item.val))

    if item.left is not None:
        item.left.level = item.level + 1
        queue.append(item.left)
    if item.right is not None:
        item.right.level = item.level + 1
        queue.append(item.right)

    level_order_traversal(item.left, queue, cur + 1, max_level)
    level_order_traversal(item.right, queue, cur + 1, max_level)


def __main__():
    node = Node(10)
    node.left = Node(5)
    node.right = Node(15)
    node.left.left = Node(1)
    node.left.right = Node(8)
    node.left.left.left = Node(11)
    node.left.left.right = Node(13)
    node.left.left.left.left = Node(18)
    node.left.right.left = Node(28)
    node.left.right.right = Node(38)
    node.left.right.right.right = Node(58)
    node.right.left = Node(-100)
    node.right.right = Node(-50)
    node.right.left.left = Node(-125)
    node.right.left.right = Node(-25)
    node.right.right.left = Node(-10)
    node.right.right.right = Node(0)

    in_order(node)
    print()
    in_order_iterative_using_stack(node)
    print("")
    print(find_diameter(node))
    queue = list()
    queue.append(node)
    max_level = 0
    level_order_traversal(node, queue, 1, max_level)


if __name__ == '__main__':
    __main__()
