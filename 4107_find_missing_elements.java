class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> a = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i=0;i<n -1;i++) {
            for (int j=nums[i] +1;j<nums[i+1];j++) {
                a.add(j);

    }
}
return a;
    }
}