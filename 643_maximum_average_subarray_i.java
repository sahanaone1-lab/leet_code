class Solution{
    public double findMaxAverage(int[] nums,int k){
        int sum=0,i;
        for(i=0;i<k;i++){
            sum +=nums[i];
        }
        int maxsum= sum;
        for(i=k;i<nums.length;i++){
            sum -=nums[i-k];
            sum +=nums[i];
            maxsum = Math.max(maxsum, sum);
        }
        return (double) maxsum/k;
    }
}