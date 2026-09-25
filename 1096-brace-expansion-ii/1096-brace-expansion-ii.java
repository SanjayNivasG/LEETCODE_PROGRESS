class Solution {
    TreeSet<String>set=new TreeSet<>();

    public List<String> braceExpansionII(String ep) {
        dfs(ep);
        return new ArrayList<>(set);
    }

    void dfs(String s) {
        int k=s.indexOf('}');

        if (k==-1) {
            set.add(s);
            return;
        }

        int l=s.lastIndexOf('{',k);

        String lp=s.substring(0,l);
        String rp=s.substring(k+1);

        String in=s.substring(l+1,k);

        for (String p:in.split(",")) {
            dfs(lp+p+rp);
        }
    }
}