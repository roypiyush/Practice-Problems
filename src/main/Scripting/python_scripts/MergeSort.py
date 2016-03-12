#!/usr/bin/env python3

def inversionMerge(arr, i, q, j):
  larr = arr[i:q];
  rarr = arr[q:j];
  ls = q - i;
  rs = j - q;

  inv = 0;
  l = 0;
  r = 0;
  k = i;
  while(k < j):
    if(l < ls and r < rs and larr[l] <= rarr[r]):
      arr[k] = larr[l];
      l = l + 1
      k = k + 1
    if(l < ls and r < rs and larr[l] > rarr[r]):
      inv = inv + 1;
      arr[k] = rarr[r];
      r = r + 1
      k = k + 1
    if(l == ls and r < rs):
      arr[k] = rarr[r];
      r = r + 1
      k = k + 1
    if(l < ls and r == rs):
      inv = inv + 1;
      arr[k] = larr[l];
      l = l + 1
      k = k + 1

  return int(inv);

def inversionMergeSort(arr, i, j):
  if(i + 1 < j):
    mid = int((i + j) / 2)
    x = inversionMergeSort(arr, i, mid);
    y = inversionMergeSort(arr, mid, j);
    z = inversionMerge(arr, i, mid, j);
    return int(x + y - z);


def merge(arr, i, q, j):
  larr = arr[i:q];
  rarr = arr[q:j];
  ls = q - i;
  rs = j - q;

  l = 0;
  r = 0;
  k = i;
  while(k < j):
    if((l < ls and r == rs) or (l < ls and r < rs and larr[l] <= rarr[r])):
      arr[k] = larr[l];
      l = l + 1
      k = k + 1
    if((l == ls and r < rs) or (l < ls and r < rs and larr[l] > rarr[r])):
      arr[k] = rarr[r];
      r = r + 1
      k = k + 1
    #if(l == ls and r < rs):
    #  arr[k] = rarr[r];
    #  r = r + 1
    #  k = k + 1
    #if(l < ls and r == rs):
    #  arr[k] = larr[l];
    #  l = l + 1
    #  k = k + 1
    

def mergeSort(arr, i, j):
  if(i + 1 < j):
    mid = int((i + j) / 2)
    mergeSort(arr, i, mid);
    mergeSort(arr, mid, j);
    merge(arr, i, mid, j);

arr = [6, 5, 4, 3, 2, 1, 232, 32, 31, 23, 6, 343, 83, 31, 86, 40, 76, 73, 59, 61, 634, 9565, 123137]
mergeSort(arr, 0, len(arr));
#inversions = inversionMergeSort(arr, 0, len(arr));
print (arr);
#print ("Inversions %d", inversions);
