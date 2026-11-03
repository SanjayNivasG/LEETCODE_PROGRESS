class Solution {
    public int minMoves(int[] nums) {
        
        int m=0;
        int sum=0;

        for(int x:nums){
            m=Math.max(m,x);
            sum+=x;
        }
        return m*nums.length-sum;
    }
}