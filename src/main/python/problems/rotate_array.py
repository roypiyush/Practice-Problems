#!/usr/bin/python


def gcd(a, b):
    if b > a:
        a, b = b, a
    while a % b != 0:
        a, b = b, a % b
    return b


def rotate(array, k):
    size = len(array)
    k = k % size
    j = 0
    g = gcd(size, k)
    while j < g:
        prev = array[j - k if j - k >= 0 else size + (j - k)]
        i = j
        while True:
            temp = array[i]
            array[i] = prev
            prev = temp
            i = (i + k) % size
            if i == j:
                break
        j = j + 1


if __name__ == '__main__':
    input_array = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    rotate(input_array, 6)
    print(input_array)
