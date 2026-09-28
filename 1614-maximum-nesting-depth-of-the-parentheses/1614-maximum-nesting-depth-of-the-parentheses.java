class Solution {
    public int maxDepth(String s) {
        
        int c=0;
        int max=0;
        for(char p:s.toCharArray()){
            if(p=='('){
                c++;
                max=Math.max(max,c);
            }else if(p==')'){
                c--;
            }
        }
        return max;
    }
}