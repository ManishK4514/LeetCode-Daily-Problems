class Solution {
    public int bestClosingTime(String customers) {
        int ans = -1, min = Integer.MAX_VALUE, n = customers.length();
        int countY = 0, countN = 0;

        for(int i = n - 1; i >= 0; i--) {
            if(customers.charAt(i) == 'Y') countY++;
        }

        for(int i = 0; i < n; i++) {
            int cost = countN + countY;
            if(cost < min) {
                min = cost;
                ans = i;
            }
            if(customers.charAt(i) == 'Y') countY--;
            if(customers.charAt(i) == 'N') countN++;
        }

        if(countN < min) return n;

        return ans;
    }
}