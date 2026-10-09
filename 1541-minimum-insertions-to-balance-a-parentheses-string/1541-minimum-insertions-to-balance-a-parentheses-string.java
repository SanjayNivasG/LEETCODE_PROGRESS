class Solution {
    public int minInsertions(String s) {
        
        int a=0;
        int op=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                op++;
            }else{
                if(i+1<s.length() && s.charAt(i+1)==')'){
                i++;
            }else{
                a++;
            }
            
            if(op>0){ 
                op--;
                }
            else{
                a++;
            }
        }
        }
        return a+op*2;
    }
}