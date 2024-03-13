class Solution {
    public int pivotInteger(int n) {
        int totalSum = (n * (n + 1))/2;
        int sqrt = (int)Math.sqrt(totalSum);
        if(sqrt * sqrt != totalSum) return -1;
        return sqrt;
    }
}