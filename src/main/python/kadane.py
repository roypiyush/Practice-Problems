#!/usr/bin/env python3.5

import copy


if __name__ == '__main__':

    stock_prices = [55, 45, 70, 80, 85, 4, 10, 20, 25, 40, 54]
    darr = copy.copy(stock_prices)

    for i in range(len(stock_prices) - 1, 0, -1):
        stock_prices[i] = stock_prices[i] - stock_prices[i - 1]

    stock_prices[0] = 0

    ii, jj = 0, 0
    max_sum, max_so_far = stock_prices[0], stock_prices[0]
    for i in range(1, len(stock_prices)):
        if max_sum + stock_prices[i] > stock_prices[i]:
            max_sum = max_sum + stock_prices[i]
        else:
            max_sum = stock_prices[i]
            ii = i
            jj = i

        if max_sum > max_so_far:
            jj = i
            max_so_far = max_sum

    print ("Result: {}".format(darr[ii - 1: jj + 1]))
    print (max_so_far)
