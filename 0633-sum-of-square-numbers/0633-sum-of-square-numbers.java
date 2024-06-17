class Solution {
    public boolean judgeSquareSum(int c) {
        if(c == 0) return true;
        int max = (int)Math.sqrt(c);

        for(int a = 1; a <= max; a++) {
            int bsquare = c - (a * a);

            int b = (int)Math.sqrt(bsquare);
            if(b * b == bsquare) {
                if((a * a) + (b * b) == c) return true;
            }
        }

        return false;
    }
}