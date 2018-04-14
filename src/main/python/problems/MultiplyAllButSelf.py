# -*- coding: utf-8 -*-
"""
Created on Sat Jan 14 21:35:01 2017

@author: piyush
"""
arr = [1, 2, 3, 4, 5]

mul = 1
for i in range(len(arr)):
    mul = mul * arr[i]
    
for i in range(len(arr)):
    print (mul/arr[i], ''.strip())
