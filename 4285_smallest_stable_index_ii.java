class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n= nums.length;
        int[] min = new int[n];
        min[n-1] = nums[n-1];
        for(int i=n-2; i>=0;i--){
            min[i] = Math.min(nums[i],min[i+1]);
        }
        int max = nums[0];
        for(int j = 0;j<n;j++){
            max= Math.max(max,nums[j]);

            if((max - min[j]) <= k){
                return j;

            }
         }
    return -1;
}
}