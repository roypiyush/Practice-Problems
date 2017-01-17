#!/usr/bin/env python3


def knapsack(weightArr, valueArr, w):
  maxValue = 0
  for i in range(0, len(weightArr)) :
    rw = weightArr[i] - w;
    if(rw > 0):
      maxValue = max(maxValue, knapsack(weightArr, valueArr, rw)


  return maxValue


val = { 30, 100, 120 };
wt = { 10, 20, 30 };
W = 50;

resultArr = []
resultArr.append(0)
resultArr.append(-1)
resultArr.append(-1)
resultArr.append(-1)

print (knapsack(wt, val, W));
