class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0, kk = k;
        int i = 0, n = chalk.length;

        for(int it : chalk) sum += it;
        kk %= sum;

        while(k >= 0) {
            if((long)chalk[i] > kk) return i;
            kk -= (long)chalk[i];
            i = (i + 1) % n;
        }
        return i;
    }
}