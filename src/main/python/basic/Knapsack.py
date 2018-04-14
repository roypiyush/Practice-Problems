#!/usr/bin/env python3.4


def knapsack(weight_arr, value_arr, w):
    if w == 0:
        return 0
    if w < 0:
        return -100000

    max_value = -1000
    for i in range(len(weight_arr)):
        rw = w - weight_arr[i]
        max_value = max(max_value, value_arr[i] + knapsack(weight_arr, value_arr, rw))
    return max_value


if __name__ == '__main__':
    val = [30, 100, 120]
    wt = [10, 20, 30]
    W = 50
    result_arr = list()
    result_arr.append(0)
    result_arr.append(-1)
    result_arr.append(-1)
    result_arr.append(-1)
    print (knapsack(wt, val, W))
