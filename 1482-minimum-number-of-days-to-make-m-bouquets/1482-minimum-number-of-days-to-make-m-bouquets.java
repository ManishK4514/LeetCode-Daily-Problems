class Solution {
    public boolean possible(int mid, int[] bloomDay, int m, int k) {
        int count = 0, bouquets = 0;

        for(int bloom : bloomDay) {
            if(bloom <= mid) {
                count++;
                if(count == k) {
                    bouquets++;
                    count = 0;
                }
            }
            else count = 0;
        }

        return bouquets >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int l = 1, r = (int)(1e9), n = bloomDay.length;

        if((long)m * (long)k > (long)(n)) return -1;

        while(l <= r) {
            int mid = l + (r - l)/2;

            if(possible(mid, bloomDay, m, k)) r = mid - 1;
            else l = mid + 1;
        }

        return l;
    }
}