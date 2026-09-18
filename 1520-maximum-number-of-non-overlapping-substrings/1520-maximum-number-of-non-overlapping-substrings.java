class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        List<String> list = new ArrayList<>();

        int[] f = new int[26];
        int[] l = new int[26];

        Arrays.fill(f, -1);

        for (int i = 0; i < s.length(); i++) {

            int c = s.charAt(i) - 'a';

            if (f[c] == -1)
                f[c] = i;

            l[c] = i;

        }

        int pr = -1;

        for (int i = 0; i < s.length(); i++) {

            int c = s.charAt(i) - 'a';

            if (f[c] != i)
                continue;

            int e = l[c];
            boolean ft = true;

            for (int j = i; j <= e; j++) {

                int x = s.charAt(j) - 'a';

                if (f[x] < i) {
                    ft = false;
                    break;
                }
                e = Math.max(l[x], e);
            }
            if (ft) {
                 if (pr >= i)
                    list.remove(list.size() - 1);

                list.add(s.substring(i, e + 1));
                pr = e;
            }
        }
        return list;
    }
}
