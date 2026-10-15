
class Solution {
    public int findTargetSumWays(int[] nums, int tg) {
        
        int sum = 0;
        for (int num:nums) {
            sum+=num;
        }
        if (Math.abs(tg)>sum) {
            return 0;
        }

        int total =sum+tg;
        if (total % 2 != 0) {
            return 0;
        }
        int s = total / 2;
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int k: nums) {
            for (int j = s; j >=k; j--) {
                dp[j] += dp[j-k];
            }
        }
        return dp[s];
    }
}
