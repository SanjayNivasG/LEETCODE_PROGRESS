class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long mod = 1000000007;
        long ans = 0;
        int[] a = new int[32];

        for (int n : nums) {
            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) != 0) {
                    a[i]++;
                }
            }
        }

        while (k-- > 0) {
            long x = 0;

            for (int i = 31; i >= 0; i--) {
                if (a[i] > 0) {
                    x |= (1L << i);
                    a[i]--;
                }
            }

            ans = (ans + x * x % mod) % mod;
        }

        return (int) ans;
    }
}