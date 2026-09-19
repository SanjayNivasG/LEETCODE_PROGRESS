class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        

        int a=xCenter;
        int b=yCenter;

        if(xCenter < x1){
            a=x1;
        }
        else if(xCenter > x2){
            a=x2;
        }

            if(yCenter < y1){
            b=y1;
            }
            else if(yCenter > y2){
            b=y2;
            }

        int dx=xCenter-a;
        int dy=yCenter-b;

        return dx*dx+dy*dy<=radius*radius;
    }
}