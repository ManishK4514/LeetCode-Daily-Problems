public class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        double dist = Math.max(Math.abs(fy - sy), Math.abs(fx - sx));
        if(dist == 0 && t == 1) return false;
        return dist <= t;
    }
}