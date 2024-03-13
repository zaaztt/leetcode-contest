package leetcode.contest.weekly.week387;

public class Q2 {

    public int countSubmatrices(int[][] grid, int k) {
        int[][] sumMatrix = new int[grid.length][grid[0].length];
        int[][] rowSumMatrix = generateRowSumMatrix(grid);
        int[][] colSumMatrix = generateColSumMatrix(grid);
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sumMatrix[i][j] = j > 0 ? sumMatrix[i][j - 1] + colSumMatrix[i][j] : colSumMatrix[i][j];
                if (sumMatrix[i][j] <= k) {
                    count++;
                }
            }
        }
        return count;
    }

    private int[][] generateRowSumMatrix(int[][] grid) {
        int[][] rowSumMatrix = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                rowSumMatrix[i][j] = j == 0 ? grid[i][j] : rowSumMatrix[i][j - 1] + grid[i][j];
            }
        }
        return rowSumMatrix;
    }

    private int[][] generateColSumMatrix(int[][] grid) {
        int[][] colSumMatrix = new int[grid.length][grid[0].length];
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                colSumMatrix[i][j] = i == 0 ? grid[i][j] : colSumMatrix[i - 1][j] + grid[i][j];
            }
        }
        return colSumMatrix;
    }
}
