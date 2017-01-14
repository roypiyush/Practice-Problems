#!/usr/bin/python3

def interleave(s1, s2, i, j, prefix):
  if(len(s1) == i and len(s2) == j):
    print (prefix)

  if(i < len(s1)):
    interleave(s1, s2, i+1, j, prefix + s1[i])
  if(j < len(s2)):
    interleave(s1, s2, i, j+1, prefix + s2[j])


s1 = "abcefgh"
s2 = "ijklmnoqrstuvwxyz"
interleave(s1, s2, 0, 0, "")
