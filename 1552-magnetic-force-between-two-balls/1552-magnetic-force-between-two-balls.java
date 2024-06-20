class Solution {
    public boolean possible(int mid, int[] position, int target) {
        int count = 1, last = position[0], n = position.length;

        for(int i = 1; i < n; i++) {
            if(position[i] - last >= mid) {
                count++;
                last = position[i];
            } 
        }

        return count >= target;
    }
    
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int l = 1, r = (int)(1e9);

        while(l <= r) {
            int mid = l + (r - l)/2;

            if(possible(mid, position, m)) l = mid + 1;
            else r = mid - 1;
        }

        return r;
    }
}