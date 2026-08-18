class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] count = new int[51];

        for (int i = 0; i <= nums.length - k; i++) {

            boolean[] present = new boolean[51];

            for (int j = 0; j < k; j++) {
                present[nums[i + j]] = true;
            }

            for (int x = 0; x <= 50; x++) {
                if (present[x]) {
                    count[x]++;
                }
            }
        }

        int ans = -1;

        for (int x = 0; x <= 50; x++) {
            if (count[x] == 1) {
                ans = x;
            }
        }

        return ans;
    }
}