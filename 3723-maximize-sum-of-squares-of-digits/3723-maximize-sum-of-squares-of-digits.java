class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum>num*9) return "";

        StringBuilder st=new StringBuilder();

        for (int i =0;i<num;i++) {
            int d=Math.min(9, sum);
            st.append(d);
            sum-= d;
        }
        return st.toString();
    }
}