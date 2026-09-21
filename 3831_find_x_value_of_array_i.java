class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            int x = num % k;
            long[] next = new long[k];

            next[x]++;

            for (int r = 0; r < k; r++) {
                if (dp[r] != 0) {
                    int nr = (int) ((long) r * x % k);
                    next[nr] += dp[r];
                }
            }

            for (int r = 0; r < k; r++) {
                result[r] += next[r];
            }

            dp = next;
        }

        return result;
    }
}