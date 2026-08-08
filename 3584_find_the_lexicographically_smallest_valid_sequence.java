class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] exact = new int[n + 1];
        int[] almost = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            exact[i] = exact[i + 1];

            if (exact[i + 1] < m &&
                word1.charAt(i) == word2.charAt(m - exact[i + 1] - 1)) {
                exact[i]++;
            }

            almost[i] = almost[i + 1];

            if (almost[i + 1] < m &&
                word1.charAt(i) == word2.charAt(m - almost[i + 1] - 1)) {
                almost[i] = almost[i + 1] + 1;
            }

            if (exact[i + 1] < m) {
                almost[i] = Math.max(almost[i], exact[i + 1] + 1);
            }
        }

        int[] ans = new int[m];

        int pos = 0;
        boolean changed = false;

        for (int j = 0; j < m; j++) {
            int remaining = m - j - 1;
            boolean found = false;

            while (pos < n) {
                if (word1.charAt(pos) == word2.charAt(j)) {

                    // Current character matches.
                    // One mismatch can still be used later.
                    if (almost[pos + 1] >= remaining) {
                        ans[j] = pos++;
                        found = true;
                        break;
                    }

                } else if (!changed) {

                    // Use the one allowed mismatch here.
                    // Everything after this must match exactly.
                    if (exact[pos + 1] >= remaining) {
                        ans[j] = pos++;
                        changed = true;
                        found = true;
                        break;
                    }
                }

                pos++;
            }

            if (!found) {
                return new int[0];
            }
        }

        return ans;
    }
}