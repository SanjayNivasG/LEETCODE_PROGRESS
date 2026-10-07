import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Queue<String> qu = new LinkedList<>();
        Set<String> set = new HashSet<>();

        qu.add(s);
        set.add(s);

        while (!qu.isEmpty()) {
            int n = qu.size();
            boolean f = false;

            while (n-- > 0) {
                String str = qu.poll();

                if (valid(str)) {
                    ans.add(str);
                    f= true;
                }

                if (f) continue;

                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) != '(' && str.charAt(i) != ')')
                        continue;

                    String next = str.substring(0, i) + str.substring(i + 1);

                    if (set.add(next))
                        qu.add(next);
                }
            }

            if (f) break;
        }

        return ans;
    }

    boolean valid(String s) {
        int ct = 0;

        for (char c : s.toCharArray()) {
            if (c =='(') ct++;
            if (c ==')') ct--;

            if (ct<0) return false;
        }

        return ct == 0;
    }
}