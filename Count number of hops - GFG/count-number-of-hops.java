//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    public static long count(int idx, long[] dp){
    if(idx == 0) return 1;
    if(idx < 0) return 0;
    if(dp[idx] != -1) return dp[idx];
    
    long ways = (count(idx - 1, dp) % (1000000007) + count(idx - 2, dp) % (1000000007) + count(idx - 3, dp) % (1000000007)) % (1000000007);
    dp[idx] = ways;
    return ways;
}

static long countWays(int n)
{
    long[] dp = new long[n + 1];
    Arrays.fill(dp, -1);
    return count(n, dp) % (1000000007);
}

    
}

