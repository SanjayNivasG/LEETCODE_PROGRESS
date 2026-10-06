class Solution {
    public int minAddToMakeValid(String s) {
        
        int op=0;
        int cl=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                op++;
            }else if(c==')'){
                if(op>0) op--;
                else
                cl++;
            }
        }
        return op+cl;
    }
}