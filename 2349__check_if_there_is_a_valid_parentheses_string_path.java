class Solution {
    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 != 0)
            return false;

        dp = new Boolean[m][n][m + n];

        return solve(grid, 0, 0, 0);
    }

    boolean solve(char[][] grid, int i, int j, int balance) {

        if (i >= grid.length || j >= grid[0].length)
            return false;

        if (grid[i][j] == '(')
            balance++;
        else
            balance--;

        if (balance < 0)
            return false;

        if (balance > grid.length + grid[0].length)
            return false;

        if (dp[i][j][balance] != null)
            return dp[i][j][balance];

        if (i == grid.length - 1 && j == grid[0].length - 1)
            return dp[i][j][balance] = (balance == 0);

        return dp[i][j][balance] =
            solve(grid, i + 1, j, balance) ||
            solve(grid, i, j + 1, balance);
    }
}