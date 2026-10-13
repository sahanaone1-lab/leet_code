class Solution {
    public boolean canAliceWin(int[] nums) {
        int count_single=0,count=0;
        for(int num:nums){
            if(num<=9){
                count_single +=num;
            }
            else{
                count +=num;
            }
        }
       return count > count_single || count_single > count;
        
        
    }
}