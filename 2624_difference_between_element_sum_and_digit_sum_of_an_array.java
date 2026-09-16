class Solution {
    public int differenceOfSum(int[] nums) {
        int asum=0;
        int dsum=0;
        for(int n:nums){
            asum+=n;
            while(n>0){
                int rev = n%10;
                dsum+=rev;
                n/=10;
            }
        }
        return asum-dsum;
        
    }
}