class Solution {
    public String generateTheString(int n) {
        return "b" + "ab".substring(n % 2, 1 + n % 2).repeat(n - 1);
    }
}