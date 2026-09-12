import java.util.*;

class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        int[][] a = new int[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }

        Arrays.sort(a, (x, y) -> x[0] - y[0]);

        ArrayList<Integer>[][] dp = new ArrayList[n + 1][5];
        long[][] sum = new long[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new ArrayList<>();
            }
        }

        for (int i = n - 1; i >= 0; i--) {

            for (int k = 1; k <= 4; k++) {

                dp[i][k] = new ArrayList<>(dp[i + 1][k]);
                sum[i][k] = sum[i + 1][k];

                int j = next(a, i + 1, a[i][1]);

                long value = a[i][2] + sum[j][k - 1];

                ArrayList<Integer> temp =
                    new ArrayList<>(dp[j][k - 1]);

                temp.add(a[i][3]);

                Collections.sort(temp);

                if (value > sum[i][k]) {
                    sum[i][k] = value;
                    dp[i][k] = temp;
                }

                if (value == sum[i][k]) {
                    if (small(temp, dp[i][k])) {
                        dp[i][k] = temp;
                    }
                }
            }
        }

        int[] ans=new int[dp[0][4].size()];

        for (int i=0;i<ans.length;i++) {
            ans[i]=dp[0][4].get(i);
        }

        return ans;
    }

    static int next(int[][] a, int l, int end) {

        int r = a.length;

        while (l<r) {
            
            int mid=(l+r)/2;
            if (a[mid][0] <= end)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    static boolean small(ArrayList<Integer> a, ArrayList<Integer> b) {

        for (int i = 0;i<a.size()&&i<b.size();i++) {

            if (!a.get(i).equals(b.get(i)))
                return a.get(i)<b.get(i);
        }
        return a.size()<b.size();
    }
}