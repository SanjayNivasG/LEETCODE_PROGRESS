class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[]a =new long[k];
        long[]dp =new long[k];

        for (int n : nums) {
            long[]next = new long[k];

            int r = n%k;
            next[r]++;

            for (int j = 0; j < k; j++) {
                next[(j*r) % k] += dp[j];
            }

            dp = next;

            for (int j=0; j<k; j++) {
                a[j] += dp[j];
            }
        }

        return a;
    }
}