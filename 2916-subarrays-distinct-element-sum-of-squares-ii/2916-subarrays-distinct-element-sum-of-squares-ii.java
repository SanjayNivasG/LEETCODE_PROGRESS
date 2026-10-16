
class Solution {
    int[] sum, lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;
        sum = new int[4 * n];
        lazy = new int[4 * n];

        int[] last = new int[100001];
        long ans = 0, cur = 0;
        long mod = 1000000007;

        for (int i = 0; i < n; i++) {
            int l = last[nums[i]];
            cur = (cur + 2L * query(1, 0, n - 1, l, i) + i - l + 1) % mod;
            update(1, 0, n - 1, l, i);
            ans = (ans + cur) % mod;
            last[nums[i]] = i + 1;
        }

        return (int) ans;
    }

    int query(int node, int s, int e, int l, int r) {
        if (l > e || r < s) return 0;
        if (l <= s && e <= r) return sum[node];

        push(node, s, e);
        int m = (s + e) / 2;

        return (int)(((long) query(node * 2, s, m, l, r)
                + query(node * 2 + 1, m + 1, e, l, r))
                % 1000000007);
    }

    void update(int node, int s, int e, int l, int r) {
        if (l > e || r < s) return;

        if (l <= s && e <= r) {
            sum[node] = (int)((sum[node] + (long)(e - s + 1))
                    % 1000000007);
            lazy[node]++;
            return;
        }

        push(node, s, e);
        int m = (s + e) / 2;

        update(node * 2, s, m, l, r);
        update(node * 2 + 1, m + 1, e, l, r);

        sum[node] = (int)(((long) sum[node * 2]
                + sum[node * 2 + 1]) % 1000000007);
    }

    void push(int node, int s, int e) {
        if (lazy[node] == 0 || s == e) return;

        int m = (s + e) / 2;
        apply(node * 2, s, m, lazy[node]);
        apply(node * 2 + 1, m + 1, e, lazy[node]);
        lazy[node] = 0;
    }

    void apply(int node, int s, int e, int v) {
        sum[node] = (int)((sum[node] + (long)(e - s + 1) * v)
                % 1000000007);
        lazy[node] += v;
    }
}
