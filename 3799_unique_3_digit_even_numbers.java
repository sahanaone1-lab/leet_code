import java.util.*;

class Solution {
    public int totalNumbers(int[] digits) {
        int count = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {

                    if (i == j || j == k || i == k)
                        continue;

                    if (digits[i] == 0)
                        continue;

                    int n = 0;
                    n = n * 10 + digits[i];
                    n = n * 10 + digits[j];
                    n = n * 10 + digits[k];

                    if (n % 2 == 0)
                        set.add(n);
                }
            }
        }

        return set.size();
    }
}