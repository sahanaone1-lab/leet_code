class Solution {
    public int missingMultiple(int[] nums, int k) {
        int mult = k;
        while (true){
            boolean found = false ;
            for(int a : nums){
                if(a == mult){
                    found = true;
                    break;
                }
            }
            if(! found){
                return mult;
            }
            mult +=k;
        }
    }
}