class Solution {
    public int digitSum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public int getLucky(String s, int k) {
        int ans = 0;
        for(char ch : s.toCharArray()) {
            ans += digitSum((ch - 'a') + 1);
        }

        while(k-- > 1) ans = digitSum(ans);
        return ans;
    }
}