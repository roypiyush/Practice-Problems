#!/usr/bin/python3.4


def prime_factors(n):
    if n == 0 or n == 1:
        return n

    i = 2
    while n != 1:
        p = n % i
        if p == 0:
            n = n / i
            print(str(i), end=' ')
            continue
        i = i + 1
    print('')


if __name__ == '__main__':
    prime_factors(8255520000)
