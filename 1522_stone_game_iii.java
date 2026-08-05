class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] scoreDiff = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
             scoreDiff[i] = Integer.MIN_VALUE;
            int sum = 0;

            for (int k = 0; k < 3 && i + k < n; k++) {
                sum += stoneValue[i + k];
                scoreDiff[i] = Math.max(scoreDiff[i], sum - scoreDiff[i + k + 1]);
            }
        }
        if (scoreDiff[0] > 0)
            return "Alice";
        else if (scoreDiff[0] < 0)
            return "Bob";
        else
            return "Tie";
        
    }
}