class Solution {

    int[][] dp;
    int[] suffix;

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return solve(0, 1, piles);
    }

    int solve(int i, int M, int[] piles) {

        if (i == piles.length) {
            return 0;
        }

        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        int answer = 0;

        for (int X = 1; X <= 2 * M && i + X <= piles.length; X++) {

            int newM = Math.max(M, X);

            int current = suffix[i]
                    - solve(i + X, newM, piles);

            answer = Math.max(answer, current);
        }

        dp[i][M] = answer;

        return answer;
    }
}