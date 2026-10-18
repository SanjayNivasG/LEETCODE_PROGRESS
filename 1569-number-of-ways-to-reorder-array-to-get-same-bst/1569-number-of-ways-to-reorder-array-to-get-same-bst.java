import java.util.*;

class Solution {
    long mod = 1000000007;
    long[] fact, inv;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        fact = new long[n + 1];
        inv = new long[n + 1];

        fact[0] = 1;
        for (int i = 1; i <= n; i++)
            fact[i] = fact[i - 1] * i % mod;

        inv[n] = pow(fact[n], mod - 2);

        for (int i = n; i >= 1; i--)
            inv[i - 1] = inv[i] * i % mod;

        return (int) ((solve(nums) - 1 + mod) % mod);
    }

    long solve(int[] a) {
        int n = a.length;
        if (n <= 2) return 1;

        List<Integer> l = new ArrayList<>();
        List<Integer> r = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (a[i] < a[0])
                l.add(a[i]);
            else
                r.add(a[i]);
        }

        int[] left = l.stream().mapToInt(Integer::intValue).toArray();
        int[] right = r.stream().mapToInt(Integer::intValue).toArray();

        long c = fact[n - 1] * inv[l.size()] % mod;
        c = c * inv[r.size()] % mod;

        return c * solve(left) % mod * solve(right) % mod;
    }

    long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}