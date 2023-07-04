//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    int mod = (int)(1e9 + 7);
    public int helper(int i, int[] arr, int target, int[][] dp){
        if(i < 0) {
            if(target == 0) return 1;
            return 0;
        }
        
        if(dp[i][target] != -1) return dp[i][target];
        
        // take 
        int take = 0;
        if(target >= arr[i]) take = helper(i - 1, arr, target - arr[i], dp);
        
        // notTake
        int notTake = helper(i - 1, arr, target, dp);
        
        return dp[i][target] = ((take % mod) + (notTake % mod)) % mod;
    }
	public int perfectSum(int[] arr,int n, int sum) {
	    int[][] dp = new int[n][sum + 1];
	    for(int[] it : dp) Arrays.fill(it, -1);
	    return helper(n - 1, arr, sum, dp) % mod;
	} 
}