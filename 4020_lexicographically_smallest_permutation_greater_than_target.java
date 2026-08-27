class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        int increasePos = -1;
        int[][] savedCount = new int[n][26];

        for (int i = 0; i < n; i++) {
            for (int c = target.charAt(i) - 'a' + 1; c < 26; c++) {
                if (count[c] > 0) {
                    increasePos = i;
                    savedCount[i] = count.clone();
                    break;
                }
            }
            int current = target.charAt(i) - 'a';

            if (count[current] == 0) {
                break;
            }

            count[current]--;
        }
        if (increasePos == -1) {
            return "";
        }

        // Restore character counts at the chosen position
        count = savedCount[increasePos].clone();

        StringBuilder answer = new StringBuilder();

        // Prefix is equal to target
        answer.append(target.substring(0, increasePos));

        int targetChar = target.charAt(increasePos) - 'a';

        // Choose the smallest character greater than target[increasePos]
        for (int c = targetChar + 1; c < 26; c++) {
            if (count[c] > 0) {
                answer.append((char) ('a' + c));
                count[c]--;
                break;
            }
        }

        for (int c = 0; c < 26; c++) {
            while (count[c] > 0) {
                answer.append((char) ('a' + c));
                count[c]--;
            }
        }

        return answer.toString();
    }
}