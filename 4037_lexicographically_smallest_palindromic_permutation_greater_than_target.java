class Solution {

    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Check whether a palindromic permutation is possible
        int oddCount = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                oddCount++;
                middle = (char) ('a' + i);
            }
        }

        if (oddCount > 1) {
            return "";
        }

        int halfLen = n / 2;

        // Count characters available for the first half
        int[] count = new int[26];

        for (int i = 0; i < 26; i++) {
            count[i] = freq[i] / 2;
        }

        char[] half = new char[halfLen];

        /*
         * Build the smallest half that is >= target's first half.
         *
         * First try to match target.
         */
        for (int i = 0; i < halfLen; i++) {
            int c = target.charAt(i) - 'a';

            if (count[c] > 0) {
                half[i] = (char) ('a' + c);
                count[c]--;
            } else {
                // Cannot match here.
                // Backtrack and find a position we can increase.
                return buildNext(half, count, i, target, middle, n);
            }
        }

        String candidate = buildPalindrome(half, middle, n);

        // If palindrome itself is greater, return it
        if (candidate.compareTo(target) > 0) {
            return candidate;
        }

        /*
         * First half is equal to target's first half,
         * but palindrome <= target.
         *
         * We need the next lexicographical permutation
         * of the first half.
         */
        return increaseHalf(half, middle, n);
    }

    private String buildNext(
            char[] half,
            int[] count,
            int position,
            String target,
            char middle,
            int n
    ) {

        // Try to increase current or previous positions
        for (int i = position; i >= 0; i--) {

            // If going backward, restore the previously chosen character
            if (i < position) {
                count[half[i] - 'a']++;
            }

            int current = target.charAt(i) - 'a';

            // Find smallest available character greater than target[i]
            for (int c = current + 1; c < 26; c++) {
                if (count[c] > 0) {

                    char[] resultHalf = new char[half.length];

                    // Copy unchanged prefix
                    for (int j = 0; j < i; j++) {
                        resultHalf[j] = half[j];
                    }

                    resultHalf[i] = (char) ('a' + c);

                    count[c]--;

                    // Fill remaining positions with smallest characters
                    int index = i + 1;

                    for (int ch = 0; ch < 26; ch++) {
                        while (count[ch] > 0) {
                            resultHalf[index++] = (char) ('a' + ch);
                            count[ch]--;
                        }
                    }

                    return buildPalindrome(resultHalf, middle, n);
                }
            }
        }

        return "";
    }

    private String increaseHalf(char[] half, char middle, int n) {
        char[] next = half.clone();

        if (!nextPermutation(next)) {
            return "";
        }

        return buildPalindrome(next, middle, n);
    }

    private String buildPalindrome(char[] half, char middle, int n) {
        StringBuilder result = new StringBuilder();

        for (char c : half) {
            result.append(c);
        }

        if (n % 2 == 1) {
            result.append(middle);
        }

        for (int i = half.length - 1; i >= 0; i--) {
            result.append(half[i]);
        }

        return result.toString();
    }

    private boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = arr.length - 1;

        while (arr[j] <= arr[i]) {
            j--;
        }

        swap(arr, i, j);
        reverse(arr, i + 1, arr.length - 1);

        return true;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left++, right--);
        }
    }
}