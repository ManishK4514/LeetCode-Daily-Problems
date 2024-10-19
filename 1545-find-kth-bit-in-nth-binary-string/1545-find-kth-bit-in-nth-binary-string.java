class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1) return '0';
        StringBuilder sb = new StringBuilder();
        sb.append("0");

        for(int i = 2; i <= n; i++) {
            StringBuilder revert = new StringBuilder();
            for(int j = 0; j < sb.length(); j++) {
                revert.append((1 - (sb.charAt(j) - '0')) + "");
            }

            sb.append("1").append(revert.reverse());
        }

        return sb.charAt(k - 1);
    }
}