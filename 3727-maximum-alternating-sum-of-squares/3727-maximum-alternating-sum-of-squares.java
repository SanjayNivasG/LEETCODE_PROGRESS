class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long sum=0;
        long[] a=new long[n];

        for (int i=0;i<n;i++) {
            a[i]=(long)nums[i]*nums[i];
        }
        Arrays.sort(a);
        for (int i=0;i<n;i++) {
            if (i < n/2)
                sum-=a[i];
            else
                sum+=a[i];
        }
        return sum;
    }
}