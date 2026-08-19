class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rows = new HashMap<>();
        for (int[] rs : reservedSeats) {
            int r = rs[0], s = rs[1];
            if (s >= 2 && s <= 9) {
                rows.put(r, rows.getOrDefault(r, 0) | (1 << (s - 2)));
            }
        }

        final int LEFT  = 0b00001111; // seats 2-5
        final int MID   = 0b00111100; // seats 4-7
        final int RIGHT = 0b11110000; // seats 6-9

        long total = (long) (n - rows.size()) * 2;

        for (int mask : rows.values()) {
            if ((mask & LEFT) == 0 && (mask & RIGHT) == 0) {
                total += 2;
            } else if ((mask & LEFT) == 0 || (mask & MID) == 0 || (mask & RIGHT) == 0) {
                total += 1;
            }
        }

        return (int) total;

        
    }
}