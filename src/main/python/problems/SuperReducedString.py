# -*- coding: utf-8 -*-
"""
Created on Sat Jan 14 16:34:49 2017

@author: piyush
"""
import sys

var = input()
size = len(var)

list = [""]
list.pop()
list.append(var[0])
for i in range(1, size):
    item = None if len(list) == 0 else list.pop();
    if(item != var[i]):
        if(item != None):
            list.append(item)
        list.append(var[i])
        
        
        
size = len(list)
for i in range(0, size):
    sys.stdout.write(list[i])
print("")
