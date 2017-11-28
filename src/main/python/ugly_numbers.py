# -*- coding: utf-8 -*-


def find(n):
    i2 = 2
    i3 = 3
    i5 = 5

    array = [0, 1, 2, 3, 4, 5]
    count = 5

    multiplier2 = 3
    multiplier3 = 2
    multiplier5 = 2

    while count <= n:
        if i2 < i3 and i2 < i5:
            count = count + 1
            i2 = i2 * multiplier2
            array.append(i2)
            multiplier2 = multiplier2 + 1
        elif i3 < i2 and i3 < i5:
            count = count + 1
            i3 = i3 * multiplier3
            array.append(i3)
            multiplier3 = multiplier3 + 1
        elif i5 < i2 and i5 < i3:
            count = count + 1
            i5 = i5 * multiplier5
            array.append(i5)
            multiplier5 = multiplier5 + 1

    return array[n]

if __name__ == '__main__':
    N = 8
    print ("N=%s Nth ugly number %d" % (N, find(n=N)))
