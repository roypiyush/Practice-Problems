#!/usr/bin/env python

def firstNaturalFactorial(x):
  if x == 0 or x == 1:
    return x

  
  mul = 1
  for i in range(2, x+1):
    print("Using Number: ", i)
    mul = mul * i
    if(mul % x == 0):
      return i
    i = i + 1

  return -1


x = 23
print("First Natural Factorial: ", firstNaturalFactorial(x))

