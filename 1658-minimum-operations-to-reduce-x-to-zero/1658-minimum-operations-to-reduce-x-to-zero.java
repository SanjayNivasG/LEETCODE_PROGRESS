class Solution {
    public int minOperations(int[] nums, int x) {
        
        int tot=0;

        for(int n:nums){
            tot+=n;
        }

        int tg=tot-x;

        if(tg<0) return -1;
        
        int l=0;
        int sum=0;
        int m=-1;


        for(int r=0;r<nums.length;r++){

            sum+=nums[r];

            while(sum>tg){
                sum-=nums[l];
                l++;
            }
            if(sum==tg){
                 m=Math.max(m,r-l+1);
            }
        }
        if(m==-1) return -1;

        return nums.length-m;
    }
}