class Solution {
    public int firstStableIndex(int[] nums, int k) {
        for(int i =0;i<nums.length;i++){
            int maxi = nums[0];
            for(int j=0;j<= i;j++){
                maxi = Math.max(maxi , nums[j]);

        }
            int mini = nums[i];
            for(int j=i+1;j<= nums.length -1;j++){
                mini = Math.min(mini, nums[j]);
            }

            int sub = maxi - mini;
            if(sub <= k){
                return i;
            }
        
    }
    return -1;
}
}