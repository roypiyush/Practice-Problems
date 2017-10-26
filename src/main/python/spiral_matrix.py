#!/usr/bin/env python3.5

import sys

matrix = [[1, 2, 3, 4, 5, 6, 7, 8, 9],
          [11, 12, 13, 14, 15, 16, 17, 18, 19],
          [21, 22, 23, 24, 25, 26, 27, 28, 29],
          [31, 32, 33, 34, 35, 36, 37, 38, 39],
          [41, 42, 43, 44, 45, 46, 47, 48, 49],
          [51, 52, 53, 54, 55, 56, 57, 58, 59]]

row_start = 0
col_start = 0
row_end = 5
col_end = 8
for i in range(row_start, row_end + 1):
    for j in range(col_start, col_end + 1):
        if matrix[i][j] in range(1, 10):
            sys.stdout.write(" %d " % matrix[i][j])
        else:
            sys.stdout.write("%d " % matrix[i][j])
    print ("")

i = 0
j = 0
is_traversable = True
while is_traversable:
    for j in range(col_start, col_end + 1):
        sys.stdout.write("%d " % matrix[i][j])
    row_start = row_start + 1

    for i in range(row_start, row_end + 1):
        sys.stdout.write("%d " % matrix[i][j])
    col_end = col_end - 1

    for j in range(col_end, col_start - 1, -1):
        sys.stdout.write("%d " % matrix[i][j])
    row_end = row_end - 1

    for i in range(row_end, row_start - 1, -1):
        if matrix[i][j] in range(1, 10):
            sys.stdout.write("%d " % matrix[i][j])
    col_start = col_start + 1

    is_traversable = row_start < row_end and col_start < col_end
