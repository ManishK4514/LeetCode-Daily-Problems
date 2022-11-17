class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int l1 = ax2 - ax1;
        int r1 = ay2 - ay1;
        int AreaR1 = l1 * r1;
        
        int l2 = bx2 - bx1;
        int r2 = by2 - by1;
        int AreaR2 = l2 * r2;

        int cx1 = Math.max(ax1, bx1);
        int cy1 = Math.max(ay1, by1);
        int cx2 = Math.min(ax2, bx2);
        int cy2 = Math.min(ay2, by2);

        int l3 = cx2 - cx1;
        int r3 = cy2 - cy1;
        int cArea = 0;
        if(l3 > 0 && r3 > 0){
            cArea = l3 * r3;
        }
        return AreaR1 + AreaR2 - cArea;
    }
}