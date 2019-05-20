import random
from functools import reduce


class SegmentTree:
    """
    This is an example of Minimum Tree using segment tree.
    """

    def __init__(self):
        self.value = 0
        self.left = None
        self.right = None

    def __str__(self):
        return " %d " % self.value


def fill_items(root, array, l, r):
    if l == r:
        root = SegmentTree()
        root.value = array[l]
        return root
    else:
        mid = (l + r) / 2
        if root is None:
            root = SegmentTree()
        root.left = fill_items(root.left, array, l, mid)
        root.right = fill_items(root.right, array, mid + 1, r)
        root.value = min(root.left.value, root.right.value)
        return root


def build_segment_tree(array):
    return fill_items(None, array, 0, len(array) - 1)


def get_min(node, ci, cj, i, j):
    if ci < i and cj < i:
        return MAX
    if ci > j and cj > j:
        return MAX
    if i <= ci and cj <= j:
        return node.value
    mid = (ci + cj) / 2
    p1 = get_min(node.left, ci, mid, i, j)
    p2 = get_min(node.right, mid + 1, cj, i, j)
    return min(p1, p2)


def update(root, l, r, index_to_update, increase_by):
    if root is None:
        return
    if l == r:
        root.value = root.value + increase_by
        return

    mid = (l + r) / 2
    if l <= index_to_update <= mid:
        update(root.left, l, mid, index_to_update, increase_by)
        root.value = min(root.left.value, root.right.value)
    elif mid < index_to_update <= r:
        update(root.right, mid + 1, r, index_to_update, increase_by)
        root.value = min(root.left.value, root.right.value)


if __name__ == '__main__':

    MAX = 101
    size = 100
    array = list(map(lambda x: random.randint(80, MAX - 1), range(size)))
    ci, cj = 0, size - 1
    i, j = 55, 90
    tree = build_segment_tree(array)
    print(min(array[i:j + 1]))
    print(get_min(tree, ci, cj, i, j))

    index_to_update = 65
    increase_value_by = -40
    array[index_to_update] = array[index_to_update] + increase_value_by
    update(tree, ci, cj, index_to_update, increase_value_by)
    print(array[index_to_update])
    print(reduce(lambda x, y: min(x, y), array[i:j + 1]))
    print(get_min(tree, ci, cj, i, j))
