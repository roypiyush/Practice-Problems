

def power(n, p):
    """
    Raise power of number, n to p and produce result
    :param n:
    :param p:
    :return:
    """
    result = 1
    while p > 0:
        if p & 1 == 1:
            result = n * result
            p = p - 1
        p = p >> 1
        n = n * n
    return result


def power_with_modulus(n, p, m):
    result = 1
    while p > 0:
        if p & 1 == 1:
            result = (n * result) % m
            p = p - 1
        p = p >> 1
        n = (n * n) % m
    return result


if __name__ == '__main__':
    print(power(2, 10))
    print(power_with_modulus(2, 10, 25))
    print(power_with_modulus(2, 5, 13))
