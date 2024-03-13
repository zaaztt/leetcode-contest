package leetcode.contest.weekly.week387;

import org.junit.Test;

import java.util.*;

public class Q3 {
    public int minimumOperationsToWriteY(int[][] grid) {
        int minOperations = grid.length * grid.length;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    minOperations = Math.min(minOperations,
                            operationsToWriteNumToYArea(grid, i) + operationsToWriteNumToNonYArea(grid, j));
                }
            }
        }
        return minOperations;
    }

    private int operationsToWriteNumToYArea(int[][] grid, int num) {
        int n = grid.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isInYArea(grid, i, j)) {
                    if (grid[i][j] != num) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private int operationsToWriteNumToNonYArea(int[][] grid, int num) {
        int n = grid.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isInYArea(grid, i, j)) {
                    if (grid[i][j] != num) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isInYArea(int[][] grid, int r, int c) {
        int n = grid.length;
        if (r < n / 2) {
            return r == c || r + c == n - 1;
        } else {
            return c == n / 2;
        }
    }

    private int[][] generateYArea(int[][] grid) {
        List<int[]> list = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m / 2; i++) {
            list.add(new int[]{i, i});
            list.add(new int[]{i, n - i - 1});
        }
        for (int i = m / 2; i < m; i++) {
            list.add(new int[]{i, n / 2});
        }
        int[][] result = new int[list.size()][2];
        result = list.toArray(result);
        return result;
    }

//    @Test
//    public void test() {
//        int[][] result = generateYArea(new int[5][5]);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i][0] + " " + result[i][1]);
//        }
//    }
}
