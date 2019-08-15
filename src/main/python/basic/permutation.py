#!/usr/bin/python3


def permute(a, left, right):
    if left == right:
        print(''.join(a))
    for i in range(left, right + 1):
        a[left], a[i] = a[i], a[left]
        permute(a, left + 1, right)
        a[left], a[i] = a[i], a[left]


if __name__ == '__main__':
    string = "ABC"
    n = len(string)
    array = list(string)
    permute(array, 0, n-1)
