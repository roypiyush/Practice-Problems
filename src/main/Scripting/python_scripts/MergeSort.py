#!/usr/bin/env python3

def merge(arr, i, q, j):
  larr = arr[i:q];
  rarr = arr[q:j];
  ls = q - i;
  rs = j - q;

  l = 0;
  r = 0;
  k = i;
  while(k < j):
    if(l < ls and r < rs and larr[l] <= rarr[r]):
      arr[k] = larr[l];
      l = l + 1
      k = k + 1
    if(l < ls and r < rs and larr[l] > rarr[r]):
      arr[k] = rarr[r];
      r = r + 1
      k = k + 1
    if(l == ls and r < rs):
      arr[k] = rarr[r];
      r = r + 1
      k = k + 1
    if(l < ls and r == rs):
      arr[k] = larr[l];
      l = l + 1
      k = k + 1
    

def mergeSort(arr, i, j):
  if(i + 1 < j):
    mid = int((i + j) / 2)
    mergeSort(arr, i, mid);
    mergeSort(arr, mid, j);
    merge(arr, i, mid, j);

arr = [6, 5, 4, 3, 2, 1]
mergeSort(arr, 0, len(arr));
print (arr);
