class Solution {
    public boolean isPossible(int[] quantities, int target, int n) {
        int count = 0;
        for(int quantity : quantities) {
            count += (quantity / target) + ((quantity % target == 0) ? 0 : 1);
        }
        return count <= n;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1, r = (int)(1e5);

        while(l <= r) {
            int mid = l + (r - l)/2;
            if(isPossible(quantities, mid, n)) r = mid - 1;
            else l = mid + 1;
        }

        return l;
    }
}