//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    public static int helper(int idx, int[] val, int[] wt, int target, int[][] dp){
        if(idx == 0) {
            if(target >= wt[0]) return val[0];
            return 0; 
        }
        
        if(dp[idx][target] != -1) return dp[idx][target];
        
        // take
        int take = Integer.MIN_VALUE;
        if(target >= wt[idx]) take = val[idx] + helper(idx - 1, val, wt, target - wt[idx], dp);
        
        // notTake
        int notTake = helper(idx - 1, val, wt, target, dp);
        
        return dp[idx][target] = Math.max(take, notTake);
    }
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int[][] dp = new int[n][W + 1];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(n - 1, val, wt, W, dp);
    } 
}


