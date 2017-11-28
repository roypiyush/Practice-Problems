# -*- coding: utf-8 -*-
import numpy


def binomial_coefficient(n, k, narray):
    """
    C(n, k) = C(n-1, k-1) + C(n-1, k)
    C(n, 0) = C(n, n) = 1

    :param n:
    :param k:
    :param narray:
    :return:
    """

    if narray[n][k] > 0:
        return narray[n][k]
    if k == 0:
        narray[n][k] = 1
        return 1
    if n == k:
        narray[n][k] = 1
        return 1

    binomial_coef = binomial_coefficient(n - 1, k - 1, narray) + binomial_coefficient(n - 1, k, narray)
    narray[n][k] = binomial_coef
    return binomial_coef


if __name__ == "__main__":
    n, k = 11, 9
    narray = numpy.zeros((n + 1, k + 1), dtype=numpy.uint64)
    print ("Binomial Coefficient %s" % binomial_coefficient(n, k, narray=narray))
