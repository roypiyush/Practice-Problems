#!/usr/bin/python3


def to_string(items):
    return ''.join(items)


def permute(a, left, right):
    """
    Function to print permutations of string
    This function takes three parameters:
    1. String
    2. Starting index of the string
    3. Ending index of the string.

    :param a:
    :param left:
    :param right:
    :return:
    """
    if left == right:
        print (to_string(a))
    else:
        for i in range(left, right+1):
            a[left], a[i] = a[i], a[left]
            permute(a, left + 1, right)
            a[left], a[i] = a[i], a[left] # backtrack


if __name__ == '__main__':
    string = "ABCDEFGHIJKLMN"
    n = len(string)
    array = list(string)
    permute(array, 0, n-1)
