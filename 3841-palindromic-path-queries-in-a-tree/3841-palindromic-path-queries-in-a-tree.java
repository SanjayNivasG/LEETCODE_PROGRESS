class Solution {
    int[] tin, tout, depth, parent;
    int[][] up;
    int[] bit;
    int timer, LOG;
    List<Integer>[] g;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        LOG = 32 - Integer.numberOfLeadingZeros(n);
        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        parent = new int[n];
        up = new int[LOG][n];
        timer = 0;

        dfs(0, 0);
        bit = new int[n + 2];

        char[] a = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int x = 1 << (a[i] - 'a');
            add(tin[i], x);
            add(tout[i] + 1, x);
        }

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            int p = q.indexOf(' ');
            int r = q.lastIndexOf(' ');
            int u = Integer.parseInt(q.substring(p + 1, r));

            if (q.charAt(0) == 'u') {
                char c = q.charAt(r + 1);
                if (a[u] != c) {
                    int x = (1 << (a[u] - 'a')) ^ (1 << (c - 'a'));
                    add(tin[u], x);
                    add(tout[u] + 1, x);
                    a[u] = c;
                }
            } else {
                int v = Integer.parseInt(q.substring(r + 1));
                int w = lca(u, v);
                int x = sum(tin[u]) ^ sum(tin[v]) ^ (1 << (a[w] - 'a'));
                ans.add((x & (x - 1)) == 0);
            }
        }
        return ans;
    }

    void dfs(int root, int p) {
        int[] st = new int[g.length];
        int[] par = new int[g.length];
        int[] idx = new int[g.length];
        int top = 0;
        st[0] = root;
        par[0] = p;

        while (top >= 0) {
            int u = st[top];
            if (idx[top] == 0) {
                tin[u] = ++timer;
                parent[u] = par[top];
                up[0][u] = par[top];
                for (int j = 1; j < LOG; j++)
                    up[j][u] = up[j - 1][up[j - 1][u]];
            }

            if (idx[top] < g[u].size()) {
                int v = g[u].get(idx[top]++);
                if (v == par[top]) continue;
                depth[v] = depth[u] + 1;
                st[++top] = v;
                par[top] = u;
                idx[top] = 0;
            } else {
                tout[u] = timer;
                top--;
            }
        }
    }

    int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int t = u; u = v; v = t;
        }

        int d = depth[u] - depth[v];
        for (int j = 0; j < LOG; j++)
            if ((d & (1 << j)) != 0) u = up[j][u];

        if (u == v) return u;

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }
        return up[0][u];
    }

    void add(int i, int x) {
        for (; i < bit.length; i += i & -i) bit[i] ^= x;
    }

    int sum(int i) {
        int x = 0;
        for (; i > 0; i -= i & -i) x ^= bit[i];
        return x;
    }
}