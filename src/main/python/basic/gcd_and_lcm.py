#!/usr/bin/env python


def gcd(m, n):
    if n > m:
        m, n = n, m

    while n != 0:
        m, n = n, m % n

    return m


if __name__ == '__main__':

    value1 = 50
    value2 = 120

    print("Finding GCD of ", value1, value2, gcd(value1, value2))
    print("Finding LCM of ", value1, value2, (value1 * value2) / gcd(value1, value2))
