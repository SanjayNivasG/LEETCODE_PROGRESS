class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;
        int ans = 0;

        for (int r =-n+1;r<n;r++) {
            for (int p = -n+1; p<n; p++) {

                int c = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {

                        int x = i + r;
                        int y = j + p;

                        if (x >=0 && x<n && y>=0 && y<n) {
                            if (img1[i][j] == 1 && img2[x][y] == 1) {
                                c++;
                            }
                        }
                    }
                }
                ans = Math.max(ans,c);
            }
        }
        return ans;
    }
}