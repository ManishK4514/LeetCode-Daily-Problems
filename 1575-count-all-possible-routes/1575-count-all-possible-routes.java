class Solution {
    int mod = (int) 1e9 + 7;
    public int helper(int[] locations, int curr, int fuel, int finish, int[][] dp){
        if(fuel < 0) return 0;
        int ans = 0;
        if(dp[curr][fuel] != -1) return dp[curr][fuel];
        if(curr == finish) ans = (ans + 1) % mod;
        for(int i = 0; i < locations.length; i++){
            if(i == curr) continue;
            int required = Math.abs(locations[i] - locations[curr]);
            ans = (ans + helper(locations, i, fuel - required, finish, dp)) % mod;          
        } 
        return dp[curr][fuel] = ans % mod;
    }
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length, ans = 0;
        int[][] dp = new int[n + 1][201];
        for(int[] it : dp) Arrays.fill(it, -1);
        for(int i = 0; i < n; i++){
            if(i == start) continue;
            int required = Math.abs(locations[i] - locations[start]);
            ans = (ans + helper(locations, i, fuel - required, finish, dp)) % mod;
        }
        // start city is the finish city then cost 0 and path 1
        if(start == finish) return (ans + 1) % mod;
        return ans % mod;
    }
}