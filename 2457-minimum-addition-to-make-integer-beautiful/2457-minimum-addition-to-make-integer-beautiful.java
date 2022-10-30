class Solution {
    public long sumOfDigit(long n){
        long sum = 0;
        while(n > 0){
            sum += n % 10;
            n/=10;
        }
        return sum;
    }
    public long makeIntegerBeautiful(long n, int target) {
        long finaln = n, base = 1;
        while (sumOfDigit(n) > target) {
            n = n / 10 + 1;
            base *= 10;
        }
        return n * base - finaln;
    }
}