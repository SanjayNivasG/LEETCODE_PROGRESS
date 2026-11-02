class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int m=0;
        int md=nums[nums.length/2];
        for(int x:nums){
            m+=Math.abs(x-md);
        }
        return m;
    }
}