class Solution {
    int ans=0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
        private int[]dfs(TreeNode value){
        if(value==null) return new int[]{0,0};

        int []l=dfs(value.left);
        int []r=dfs(value.right);
        int sum=r[0]+l[0]+value.val;
        int c=r[1]+l[1]+1;
        if(sum/c == value.val) ans++;
        return new int[]{sum,c};
        }
}