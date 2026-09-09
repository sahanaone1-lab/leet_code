class Solution {
    public long countCommas(long n) {

        if (n < 1000) {
            return 0;
        }

        else if (n < 1000000) {
            return n - 999;
        }

        else if (n < 1000000000L) {
            return 999000L
                 + (n - 999999L) * 2;
        }

        else if (n < 1000000000000L) {
            return 999000L
                 + 999000000L * 2
                 + (n - 999999999L) * 3;
        }

        else if (n < 1000000000000000L) {
            return 999000L
                 + 999000000L * 2
                 + 999000000000L * 3
                 + (n - 999999999999L) * 4;
        }

        else {
            return 999000L
                 + 999000000L * 2
                 + 999000000000L * 3
                 + 999000000000000L * 4
                 + (n - 999999999999999L) * 5;
        }
    }
}