//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long helper(int i, int amt, int[] coins, long[][] dp){
        if(i < 0) {
            if(amt == 0) return 1L;
            return 0;
        }

        if(dp[i][amt] != -1) return dp[i][amt];

        long a = 0;
        if(amt >= coins[i]) {
            a = helper(i, amt - coins[i], coins, dp);
        }

        long b = helper(i - 1, amt, coins, dp);

        return dp[i][amt] = a + b;
    }
    public long count(int coins[], int N, int sum) {
        long[][] dp = new long[N][sum + 1];
        for(long[] it : dp) Arrays.fill(it, -1L);
        return helper(N - 1, sum, coins, dp);
    }
}