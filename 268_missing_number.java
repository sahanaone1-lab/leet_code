class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int XorAll = 0;
        for(int i=0;i<=n;i++){

            XorAll ^=i;
        }
        int xornum = 0;
        for(int num:nums){
            xornum ^=num;
        }
        return XorAll^xornum;
        
    }
}
/*
int xorAll =0;
for(int i=0;i<=n;i++){
xorAll ^=i;
}
int xorNums =0;
*/