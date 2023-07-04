//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{
    int mod = (int) (1e9 + 7);
    public int helper(int i, int targetSum, int[] arr, int[][] dp){
        // base case
        if(i == 0){
            if(targetSum == 0 && arr[0] == 0) return 2;
            if(targetSum == arr[i] || targetSum == 0) return 1;
            return 0;
        }
        
        if(dp[i][targetSum] != -1) return dp[i][targetSum];
        
        // take
        int take = 0;
        if(targetSum >= arr[i]) take = helper(i - 1, targetSum - arr[i], arr, dp);
        
        // not take
        int notTake = helper(i - 1, targetSum, arr, dp);
        
        return dp[i][targetSum] =  (take + notTake) % mod;
    }
    public int countPartitions(int n, int d, int arr[]){
        int totalSum = 0;
        for(int i = 0; i < n; i++) totalSum += arr[i];
        
        if(totalSum - d < 0 || ((totalSum - d) % 2) != 0) return 0;
        
        int[][] dp = new int[n][totalSum + 1];
        for(int[] it : dp) Arrays.fill(it, -1);
        return helper(n - 1, (totalSum - d)/2, arr, dp);
    }
}