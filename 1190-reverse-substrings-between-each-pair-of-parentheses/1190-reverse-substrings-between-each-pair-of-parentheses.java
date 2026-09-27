class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        String c= "";

        for (char k : s.toCharArray()) {
            if (k == '(') {
                stack.push(c);
                c= "";
            } 
            else if (k == ')') {
                c=new StringBuilder(c).reverse().toString();
                c= stack.pop() + c;
            } 
            else {
                c += k;
            }
        }

        return c;
    }
}