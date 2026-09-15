class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int ans = 0;
        int start = 0;

        for (int end = k - 1; end < n; end++) {
            for (int i = start; i <= end - k + 1; i++) {
                if (isPalindrome(s, i, end)) {
                    ans++;
                    start = end + 1;
                    break;
                }
            }
        }

        return ans;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}