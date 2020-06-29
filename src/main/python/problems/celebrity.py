#!/usr/bin/python
import numpy


def find_celebrity(mat):
    celeb = 0
    p1 = 1

    for i in range(1, 4):
        if matrix[celeb][p1] == 1:
            celeb = p1
    return celeb


if __name__ == '__main__':
    matrix = numpy.array([[0, 0, 1, 0],
                          [0, 0, 1, 0],
                          [0, 0, 0, 0],
                          [0, 0, 1, 0]])
    celebrity = find_celebrity(matrix)
    print('Celebrity: ' + str(celebrity))
