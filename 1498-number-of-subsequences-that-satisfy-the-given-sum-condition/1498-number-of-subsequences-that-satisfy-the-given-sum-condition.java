class Solution {
    private int MOD = 1000000007;
    public long power(long aa, long n, long m) {
        long ans = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
                ans = (ans * aa * 1L) % m;
            }
            aa = ((aa * aa * 1L) % m);
            n >>= 1;
        }
        return ans % m;
    }
    public int search(int[] nums, int target, int idx){
        int l = idx, h = nums.length - 1;
        while(l <= h){
            int mid = l + (h - l)/2;
            if(nums[mid] + nums[idx] <= target) l = mid + 1;
            else h = mid - 1;
        }
        return h;
    }
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        long ans = 0;
        for(int i = 0; i < nums.length; i++){
            int curr = search(nums, target, i);
            if(curr < i) continue;
            // (a - b) mod m = ((a mod m) - (b mod m) + m) mod m
            int a = (int) power(2, (curr - i) + 1, MOD);
            int b = (int) power(2, (curr - i), MOD); 
            ans += ((a % MOD) - (b % MOD) + MOD) % MOD;
        }
        return (int)(ans % MOD);
    }
}