class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] max = new int[n + 1];
        int[] min = new int[n + 1];
        int[] drop = new int[n];

        for (int i = 0; i < n; i++) {
            max[i + 1] = Math.max(max[i], nums[i]);
        }

        min[n] = 1000000000;
        for (int i = n - 1; i >= 0; i--) {
            min[i] = Math.min(nums[i], min[i + 1]);
        }

        for (int i = 1; i < n; i++) {
            drop[i] = drop[i - 1] + (nums[i - 1] > nums[i] ? 1 : 0);
        }

        int ans = 0;

        for (int k = 1; k <= n / k; k++) {
            if (n % k == 0) {
                if (check(nums, max, min, drop, k)) {
                    ans += k;
                }

                int other = n / k;
                if (other != k && check(nums, max, min, drop, other)) {
                    ans += other;
                }
            }
        }

        return ans;
    }

    private boolean check(int[] nums, int[] max, int[] min, int[] drop, int k) {
        int n = nums.length;

        for (int start = 0; start < n; start += k) {
            int end = start + k - 1;
            int count = drop[end] - drop[start];

            if (nums[end] > nums[start]) {
                count++;
            }

            if (count > 1 || max[start] > min[start]) {
                return false;
            }
        }

        return true;
    }
}