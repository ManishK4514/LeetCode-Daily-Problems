class Solution {
    public int minOperations(String s) {
        // starts with 0
        int curr = 0, n = s.length(), cnt1 = 0, cnt2 = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) - '0' != curr) cnt1++;
            curr = 1 - curr;
        }

        // starts with 1
        curr = 1;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) - '0' != curr) cnt2++;
            curr = 1 - curr;
        }

        return Math.min(cnt1, cnt2);
    }
}