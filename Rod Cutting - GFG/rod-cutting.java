//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int helper(int[] price, int i, int n, int[][] dp){
        // base case
        if(i == 0) return n * price[0];
        
        if(dp[i][n] != -1) return dp[i][n];
        
        // take
        int a = Integer.MIN_VALUE;
        if(i + 1 <= n) a = price[i] + helper(price, i, n - (i + 1), dp);
        
        // not take
        int b = 0 + helper(price, i - 1, n, dp);
        
        return dp[i][n] = Math.max(a, b);
    }
    
    public int cutRod(int price[], int n) {
        int[][] dp = new int[n][n + 1];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(price, n - 1, n, dp);
    }   
}