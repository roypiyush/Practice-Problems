/**
 *
 */
package com.hackerrank.searching;

import java.util.Scanner;

/**
 * @author piyush
 */
public class ConnectedCellInGrid {

    private static int dfs(char[][] grid, int m, int n, int i, int j) {

        if (i < 0 || i >= m || j < 0 || j >= n)
            return 0;

        if (grid[i][j] == 'N' || grid[i][j] == 'X') {
            return 0;
        }

        grid[i][j] = 'X';

        int x = dfs(grid, m, n, i + 1, j)
                + dfs(grid, m, n, i - 1, j)
                + dfs(grid, m, n, i, j + 1)
                + dfs(grid, m, n, i, j - 1)
                + dfs(grid, m, n, i + 1, j + 1)
                + dfs(grid, m, n, i - 1, j - 1)
                + dfs(grid, m, n, i + 1, j - 1)
                + dfs(grid, m, n, i - 1, j + 1)
                + 1;


        return x;

    }

    /*
     *  4
        4
        1 1 0 0
        0 1 1 0
        0 0 1 0
        1 0 0 0
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int m = s.nextInt(); // rows
        int n = s.nextInt(); // cols

        char[][] grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = s.nextInt();
                if (x == 1) {
                    grid[i][j] = 'Y';
                } else if (x == 0) {
                    grid[i][j] = 'N';
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                max = Math.max(max, dfs(grid, m, n, i, j));

            }
        }
        System.out.println(max);

        s.close();
    }

}
