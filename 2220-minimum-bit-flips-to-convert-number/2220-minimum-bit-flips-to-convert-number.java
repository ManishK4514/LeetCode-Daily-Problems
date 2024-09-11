class Solution {
    public int minBitFlips(int start, int goal) {
        int flips = 0;
        for(int i = 0; i < 32; i++) {
            int startBit = (start & (1 << i)) == 0 ? 0 : 1;
            int goalBit = (goal & (1 << i)) == 0 ? 0 : 1;
            if(startBit != goalBit) flips++;
        }
        return flips;
    }
}