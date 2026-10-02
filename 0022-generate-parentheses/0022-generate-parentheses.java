class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> a = new ArrayList<>();
        generate(a, "", 0, 0, n);
        return a;
    }

    void generate(List<String> ans, String s, int op, int close, int n) {
        if(s.length()==2*n) {
            ans.add(s);
            return;
        }
        if(op<n) {
            generate(ans, s + "(", op+1, close, n);
        }

        if (close < op) {
            generate(ans, s + ")", op, close + 1, n);
        }
    }
}