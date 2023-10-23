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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int helper(int i, int prevIdx, int[] arr, int[][] dp) {
        if(i == arr.length) return 0;
        
        if(dp[i][prevIdx + 1] != -1) return dp[i][prevIdx + 1];
        
        int pick = 0;
        if(prevIdx == -1 || arr[prevIdx] < arr[i]) pick = arr[i] + helper(i + 1, i, arr, dp);
        
        int notPick = helper(i + 1, prevIdx, arr, dp);
        
        return dp[i][prevIdx + 1] = Math.max(pick, notPick);
    }
	public int maxSumIS(int arr[], int n)  
	{  
	    int[][] dp = new int[n][n + 1];
	    for(int[] it : dp) Arrays.fill(it, -1);
	    return helper(0, -1, arr, dp);
	}  
}