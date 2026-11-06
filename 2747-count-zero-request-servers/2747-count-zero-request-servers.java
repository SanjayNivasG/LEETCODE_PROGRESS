
import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        Integer[] idx = new Integer[queries.length];

        for (int i = 0; i < queries.length; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) -> Integer.compare(queries[a], queries[b]));

        int[] ans = new int[queries.length];
        int[] count = new int[n + 1];

        int left = 0, right = 0, active = 0;

        for (int i : idx) {

            int start = queries[i] - x;
            int end = queries[i];

            while (right < logs.length && logs[right][1] <= end) {
                int server = logs[right][0];

                if (count[server] == 0) {
                    active++;
                }

                count[server]++;
                right++;
            }

            while (left < right && logs[left][1] < start) {
                int server = logs[left][0];

                count[server]--;

                if (count[server] == 0) {
                    active--;
                }

                left++;
            }

            ans[i] = n - active;
        }

        return ans;
    }
}
