import java.util.*;

class Solution {
    private int[][] f;
    private final int[] twoExp = new int[10];
    private final int[] threeExp = new int[10];

    public String smallestNumber(String num, long t) {
        long tt = t;
        int e2 = 0, e3 = 0, e5 = 0, e7 = 0;
        while (tt % 2 == 0) { tt /= 2; e2++; }
        while (tt % 3 == 0) { tt /= 3; e3++; }
        while (tt % 5 == 0) { tt /= 5; e5++; }
        while (tt % 7 == 0) { tt /= 7; e7++; }
        if (tt != 1) return "-1";

        twoExp[2] = 1; twoExp[4] = 2; twoExp[6] = 1; twoExp[8] = 3;
        threeExp[3] = 1; threeExp[6] = 1; threeExp[9] = 2;

        // f[a][b] = min digits to reach >= a twos and >= b threes
        f = new int[e2 + 1][e3 + 1];
        final int INF = Integer.MAX_VALUE / 2;
        for (int[] row : f) Arrays.fill(row, INF);
        f[0][0] = 0;
        int[] usable = {2, 3, 4, 6, 8, 9};
        for (int a = 0; a <= e2; a++) {
            for (int b = 0; b <= e3; b++) {
                if (a == 0 && b == 0) continue;
                int best = INF;
                for (int d : usable) {
                    int na = Math.max(0, a - twoExp[d]);
                    int nb = Math.max(0, b - threeExp[d]);
                    if (f[na][nb] + 1 < best) best = f[na][nb] + 1;
                }
                f[a][b] = best;
            }
        }

        int L = num.length();
        int[] p2 = new int[L + 1], p3 = new int[L + 1], p5 = new int[L + 1], p7 = new int[L + 1];
        int firstZero = L;
        for (int i = 0; i < L; i++) {
            int d = num.charAt(i) - '0';
            p2[i + 1] = p2[i] + twoExp[d];
            p3[i + 1] = p3[i] + threeExp[d];
            p5[i + 1] = p5[i] + (d == 5 ? 1 : 0);
            p7[i + 1] = p7[i] + (d == 7 ? 1 : 0);
            if (d == 0 && firstZero == L) firstZero = i;
        }

        // Case: num itself works
        if (firstZero == L) {
            int r2 = Math.max(0, e2 - p2[L]);
            int r3 = Math.max(0, e3 - p3[L]);
            int r5 = Math.max(0, e5 - p5[L]);
            int r7 = Math.max(0, e7 - p7[L]);
            if (r2 == 0 && r3 == 0 && r5 == 0 && r7 == 0) return num;
        }

        int startI = Math.min(L - 1, firstZero);
        for (int i = startI; i >= 0; i--) {
            int r2b = Math.max(0, e2 - p2[i]);
            int r3b = Math.max(0, e3 - p3[i]);
            int r5b = Math.max(0, e5 - p5[i]);
            int r7b = Math.max(0, e7 - p7[i]);
            int remaining = L - i - 1;
            int startD = (num.charAt(i) - '0') + 1;
            for (int d = startD; d <= 9; d++) {
                int r2n = Math.max(0, r2b - twoExp[d]);
                int r3n = Math.max(0, r3b - threeExp[d]);
                int r5n = Math.max(0, r5b - (d == 5 ? 1 : 0));
                int r7n = Math.max(0, r7b - (d == 7 ? 1 : 0));
                long need = (long) f[r2n][r3n] + r5n + r7n;
                if (need <= remaining) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append((char) ('0' + d));
                    sb.append(buildSuffix(remaining, r2n, r3n, r5n, r7n));
                    return sb.toString();
                }
            }
        }

        int minSlotsTotal = f[e2][e3] + e5 + e7;
        int newLen = Math.max(L + 1, minSlotsTotal);
        return buildSuffix(newLen, e2, e3, e5, e7);
    }

    private String buildSuffix(int length, int r2, int r3, int r5, int r7) {
        StringBuilder sb = new StringBuilder();
        int cr2 = r2, cr3 = r3, cr5 = r5, cr7 = r7;
        for (int pos = 0; pos < length; pos++) {
            int remaining = length - pos - 1;
            for (int d = 1; d <= 9; d++) {
                int nr2 = Math.max(0, cr2 - twoExp[d]);
                int nr3 = Math.max(0, cr3 - threeExp[d]);
                int nr5 = Math.max(0, cr5 - (d == 5 ? 1 : 0));
                int nr7 = Math.max(0, cr7 - (d == 7 ? 1 : 0));
                long need = (long) f[nr2][nr3] + nr5 + nr7;
                if (need <= remaining) {
                    sb.append((char) ('0' + d));
                    cr2 = nr2; cr3 = nr3; cr5 = nr5; cr7 = nr7;
                    break;
                }
            }
        }
        return sb.toString();
    }
}