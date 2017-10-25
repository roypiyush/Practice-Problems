import math
import random


def fill_items(tree, array, l, r):
    if l > r:
        return 0
    if l == r:
        if len(array) == 0:
            return -1
        tree[l] = array.pop(0)
        return tree[l]

    mid = (l + r) / 2
    left_item = fill_items(tree, array, l, mid - 1)
    right_item = fill_items(tree, array, mid + 1, r)

    if left_item > 0 and right_item == -1:
        return left_item
    if left_item > 0 and right_item > 0:
        tree[mid] = left_item + right_item
        return tree[mid]

    return -1


def build_segment_tree(array):

    height = math.ceil(math.log(len(array), 2))
    size = 2 * int(math.pow(2, height)) - 1
    tree = map(lambda x: None, range(size))

    # add elements to tree
    fill_items(tree, array, 0, len(tree) - 1)
    return tree


def left(x):
    return x/2


def right(x):
    return x + x/2 + 1


def sum_util(tree, i, j, ti, tj):
    index = len(tree) / 2
    return get_sum(tree, i, j, ti, tj, index)


def get_sum(tree, i, j, ti, tj, node_index):

    if i > j or ti > tj:
        return 0
    if i == ti and tj == j:
        return tree[node_index]
    mid = (ti + tj) >> 1
    left_child = get_sum(tree, i, j if mid > j else mid, ti, mid, left(node_index))
    right_child = get_sum(tree, mid + 1, j, mid + 1, tj, right(node_index))
    return left_child + right_child


def update_item(tree, i):
    pass


if __name__ == '__main__':

    size = 3
    array = [1, 3, 5, 7, 9, 11, 3] # map(lambda x: random.randint(1, 100), range(size))
    size = len(array)
    print array
    print reduce(lambda x, y: x + y, array[1:5])
    tree = build_segment_tree(array)
    print tree
    compact = filter(lambda x: x is not None, tree)
    print compact
    print ("%d %d %d" % (size, len(tree), len(compact)))
    print sum_util(tree, 1, 4, 0, 6)

