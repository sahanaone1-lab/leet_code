class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + stoneValue[i];
        }

        int[][] dp = new int[n][n]; // dp[i][j] = best score for stoneValue[i..j]

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                int best = 0;
                for (int k = i; k < j; k++) {
                    long leftSum = pre[k + 1] - pre[i];
                    long rightSum = pre[j + 1] - pre[k + 1];

                    if (leftSum < rightSum) {
                        best = Math.max(best, dp[i][k] + (int) leftSum);
                    } else if (leftSum > rightSum) {
                        best = Math.max(best, dp[k + 1][j] + (int) rightSum);
                    } else {
                        best = Math.max(best, Math.max(dp[i][k], dp[k + 1][j]) + (int) leftSum);
                    }
                }
                dp[i][j] = best;
            }
        }

        return dp[0][n - 1];
    }
}