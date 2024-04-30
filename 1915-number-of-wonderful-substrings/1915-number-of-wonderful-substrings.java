class Solution {
    public long wonderfulSubstrings(String word) {
        long[] count = new long[1024]; 
        count[0] = 1;
        int mask = 0;
        long ans = 0;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            int idx = c - 'a';
            mask ^= 1 << idx;
            ans += count[mask]; 
            for (int i = 1; i <= 512; i*=2) {
                ans += count[mask ^ i];
            }
            count[mask]++; 
        }
        return ans;
    }
}