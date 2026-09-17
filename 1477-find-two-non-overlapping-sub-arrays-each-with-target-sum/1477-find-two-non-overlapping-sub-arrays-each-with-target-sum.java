class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        
        int n=arr.length;
        int []b=new int[n];

        int l=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;

        for(int r=0;r<n;r++){

            sum+=arr[r];

            while(sum>target){
                sum-=arr[l];
                l++;
            }

            if(sum==target){

                int len=r-l+1;

                if(l>0 && b[l-1]!=0){
                    ans=Math.min(ans,len+b[l-1]);
                }

                min=Math.min(len,min);
            }
                b[r]=min ==Integer.MAX_VALUE ? 0:min;
        }
        return ans==Integer.MAX_VALUE ? -1:ans;
    }
}