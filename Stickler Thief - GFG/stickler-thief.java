//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int helper(int i, int[] arr, int[] dp) {
        if(i >= arr.length) return 0;
        
        if(dp[i] != -1) return dp[i];
        
        int pick = arr[i] + helper(i + 2, arr, dp);
        int notPick = helper(i + 1, arr, dp);
        
        return dp[i] = Math.max(pick, notPick);
    }
    public int FindMaxSum(int arr[], int n)
    {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(0, arr, dp);
    }
}