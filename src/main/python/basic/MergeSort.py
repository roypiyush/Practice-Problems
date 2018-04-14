#!/usr/bin/env python3


def inversion_merge(arr, i, q, j):
    larr = arr[i:q]
    rarr = arr[q:j]
    ls = q - i
    rs = j - q

    inv = 0
    l = 0
    r = 0
    k = i
    while (k < j):
        if (l < ls and r < rs and larr[l] <= rarr[r]):
            arr[k] = larr[l]
            l = l + 1
            k = k + 1
        if (l < ls and r < rs and larr[l] > rarr[r]):
            inv = inv + 1
            arr[k] = rarr[r]
            r = r + 1
            k = k + 1
        if (l == ls and r < rs):
            arr[k] = rarr[r]
            r = r + 1
            k = k + 1
        if (l < ls and r == rs):
            inv = inv + 1
            arr[k] = larr[l]
            l = l + 1
            k = k + 1

    return int(inv)


def inversion_merge_sort(arr, i, j):
    if i + 1 < j:
        mid = int((i + j) / 2)
        x = inversion_merge_sort(arr, i, mid)
        y = inversion_merge_sort(arr, mid, j)
        z = inversion_merge(arr, i, mid, j)
        return int(x + y - z)


def merge(arr, i, q, j):
    larr = arr[i:q]
    rarr = arr[q:j]
    ls = q - i
    rs = j - q

    l = 0
    r = 0
    k = i
    while k < j:
        if (l < ls and r == rs) or (l < ls and r < rs and larr[l] <= rarr[r]):
            arr[k] = larr[l]
            l = l + 1
            k = k + 1
        if (l == ls and r < rs) or (l < ls and r < rs and larr[l] > rarr[r]):
            arr[k] = rarr[r]
            r = r + 1
            k = k + 1


def merge_sort(arr, i, j):
    if i + 1 < j:
        mid = int((i + j) / 2)
        merge_sort(arr, i, mid)
        merge_sort(arr, mid, j)
        merge(arr, i, mid, j)


array_item = [6, 5, 4, 3, 2, 1, 232, 32, 31, 23, 6, 343, 83, 31, 86, 40, 76, 73, 59, 61, 634, 9565, 123137]
merge_sort(array_item, 0, len(array_item))
print (array_item)
