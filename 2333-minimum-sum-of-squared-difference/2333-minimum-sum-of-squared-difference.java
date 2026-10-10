import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] a = new int[n];
        long k = (long) k1 + k2;
        long total = 0;

        for (int i = 0; i < n; i++) {
            a[i] = Math.abs(nums1[i] - nums2[i]);
            total += a[i];
        }

        if (total <= k) return 0;

        Arrays.sort(a);

        int l = 0, r = a[n - 1];

        while (l < r) {
            int mid = l + (r - l) / 2;
            long need = 0;

            for (int x : a) {
                if (x > mid) need += x - mid;
            }

            if (need <= k) r = mid;
            else l = mid + 1;
        }

        long used = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > l) {
                used += a[i] - l;
                a[i] = l;
            }
        }

        long rem = k - used;

        for (int i = n - 1; i >= 0 && rem > 0; i--) {
            if (a[i] == l && l > 0) {
                a[i]--;
                rem--;
            }
        }

        long ans = 0;
        for (int x : a) {
            ans += (long) x * x;
        }

        return ans;
    }
}