class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        int l = Math.max(rec1[0], rec2[0]);
        int r = Math.min(rec1[2], rec2[2]);

        int b = Math.max(rec1[1], rec2[1]);
        int t = Math.min(rec1[3], rec2[3]);

        return l < r && b < t;
    }
}