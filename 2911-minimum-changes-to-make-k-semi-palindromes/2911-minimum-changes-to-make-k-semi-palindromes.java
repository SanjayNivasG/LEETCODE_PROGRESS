
class Solution {
    int[][] cost;
    int n;

    int getCost(String s, int l, int r) {
        int len = r - l + 1;
        int ans = n;

        for (int d = 1; d < len; d++) {
            if (len % d != 0) continue;

            int cnt = 0;

            for (int i = 0; i < d; i++) {
                int a = l + i;
                int b = r - d + 1 + i;

                while (a < b) {
                    if (s.charAt(a) != s.charAt(b)) cnt++;
                    a += d;
                    b -= d;
                }
            }

            ans = Math.min(ans, cnt);
        }

        return ans;
    }

    public int minimumChanges(String s, int k) {
        n = s.length();
        cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = getCost(s, i, j);
            }
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int[] row : dp)
            java.util.Arrays.fill(row, 1000000);

        dp[0][0] = 0;

        for (int i = 2; i <= n; i++) {
            for (int p = 1; p <= k; p++) {
                for (int j = 0; j <= i - 2; j++) {
                    dp[i][p] = Math.min(
                        dp[i][p],
                        dp[j][p - 1] + cost[j][i - 1]
                    );
                }
            }
        }

        return dp[n][k];
    }
}
