package com.personal.array;

public class RotateMatrix {

    public static void main(String... args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        example(matrix1);

        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        example(matrix2);
    }

    private static void example(int[][] matrix) {
        System.out.println("===========================");
        printMatrix(matrix);
        RotateMatrix rotateMatrix = new RotateMatrix();
        rotateMatrix.rotate90Degrees(matrix, matrix.length);
        rotateMatrix.rotate90Degrees(matrix, matrix.length);
        rotateMatrix.rotate90Degrees(matrix, matrix.length);
        rotateMatrix.rotate90Degrees(matrix, matrix.length);
        System.out.println("---------------------");
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(ints[j] + "   ");
            }
            System.out.println();
        }
    }

    private void rotate90Degrees(int[][] matrix, int size) {
        int iMin = 0; int iMax = size - 1;
        while (iMin < iMax) {
            int j = iMin;
            while (j < iMax) {
                int moveBy = iMax - iMin;
                int nextElement = matrix[iMin][j];
                int[] pos = new int[]{iMin, j};

                for (int d = 1; d <= 4; d++) {
                    int currentElement = nextElement;
                    pos = nextPosition(pos[0], pos[1], iMin, iMax, moveBy, d);
                    nextElement = matrix[pos[0]][pos[1]];
                    matrix[pos[0]][pos[1]] = currentElement;
                }
                j++;
            }
            iMin++;
            iMax--;
        }
    }

    private int[] nextPosition(int i, int j, int iMin, int iMax, int moveBy, int currentDirection) {
        if (currentDirection == 1) {
            int diff = j + moveBy - iMax;
            return new int[]{i + diff, iMax};
        } else if (currentDirection == 2) {
            int diff = i + moveBy - iMax;
            return new int[]{iMax, iMax - diff};
        } else if (currentDirection == 3) {
            int diff = moveBy - (j - iMin);
            return new int[] {iMax - diff , iMin};
        } else if (currentDirection == 4) {
            int diff = moveBy - (i - iMin);
            return new int[] {iMin, iMin + diff};
        } else {
            throw new RuntimeException("Invalid Direction");
        }
    }

}
