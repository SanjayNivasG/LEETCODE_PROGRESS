
class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        int even = 1, odd = 0;
        int sum = 0, ans = 0;

        for (int x : arr) {
            sum += x;

            if (sum % 2 == 0) {
                ans = (ans + odd) % mod;
                even++;
            } else {
                ans = (ans + even) % mod;
                odd++;
            }
        }

        return ans;
    }
}
