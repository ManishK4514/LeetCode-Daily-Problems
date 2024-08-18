class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        
        int i2 = 0, i3 = 0, i5 = 0;
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;
        int nextUglyNumber = 1;
        
        for (int i = 1; i < n; i++) {
            nextUglyNumber = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            uglyNumbers[i] = nextUglyNumber;
            
            if (nextUglyNumber == nextMultipleOf2) {
                i2++;
                nextMultipleOf2 = uglyNumbers[i2] * 2;
            }
            if (nextUglyNumber == nextMultipleOf3) {
                i3++;
                nextMultipleOf3 = uglyNumbers[i3] * 3;
            }
            if (nextUglyNumber == nextMultipleOf5) {
                i5++;
                nextMultipleOf5 = uglyNumbers[i5] * 5;
            }
        }
        
        return uglyNumbers[n - 1];
    }
}
