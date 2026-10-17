import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            int x = nums[i], sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            a[i][0] = sum;
            a[i][1] = nums[i];
        }

        Arrays.sort(a, (x, y) -> {
            if (x[0] != y[0])
                return x[0] - y[0];
            return x[1] - y[1];
        });

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(a[i][1], i);

        int[] p = new int[n];
        for (int i = 0; i < n; i++)
            p[i] = map.get(nums[i]);

        boolean[] seen = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (seen[i] || p[i] == i)
                continue;

            int j = i, count = 0;
            while (!seen[j]) {
                seen[j] = true;
                j = p[j];
                count++;
            }
            ans += count - 1;
        }

        return ans;
    }
}