class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        
        int []a=new int[seq.length()];
        int dp=0;

        for(int i=0;i<seq.length();i++){
            if(seq.charAt(i)=='('){
                dp++;
                a[i]=dp%2;
            }else if(seq.charAt(i)==')'){
                a[i]=dp%2;
                dp--;
            }
        }
        return a;
    }
}