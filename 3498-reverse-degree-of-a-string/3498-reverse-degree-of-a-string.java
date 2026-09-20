class Solution {
    public int reverseDegree(String s) {
        
        int v=0;
        for(int i=0;i<s.length();i++){
            int k=26-(s.charAt(i)-'a');
            v+=k*(i+1);
        }
        return v;
    }
}