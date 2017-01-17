#!/usr/bin/env python3.4

def max(a, b):
  a if int(a) > int(b) else b;

def knapsack(weightArr, valueArr, w):

  if(w == 0):
    return 0;
  if(w < 0):
    return -100000;

  maxValue = -1000
  for i in range(len(weightArr)):
    rw = weightArr[i] - w
    maxValue = max(int(maxValue), int(valueArr[i]) + int(knapsack(weightArr, valueArr, rw)))
  return maxValue;


val = [30, 100, 120];
wt = [10, 20, 30];
W = 50;

resultArr = []
resultArr.append(0)
resultArr.append(-1)
resultArr.append(-1)
resultArr.append(-1)

print (knapsack(wt, val, W));
