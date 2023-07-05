//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A,N, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTargetSumWays(int[] nums, int n, int target) {
        int totalSum = 0;
        for(int i = 0; i < n; i++) totalSum += nums[i];
        
        if(totalSum - target < 0 || ((totalSum - target) % 2) != 0) return 0;

        int targetSum = (totalSum - target)/2;
           
        int[] prev = new int[targetSum + 1];
        int[] curr = new int[targetSum + 1];
        
        if(nums[0] == 0) prev[0] = 2;
        else prev[0] = 1;
        
        if(nums[0] != 0 && nums[0] <= targetSum) prev[nums[0]] = 1;
        
        for(int i = 1; i < n; i++){
            for(int sum = 0; sum <= targetSum; sum++){
                // take
                int take = 0;
                if(sum >= nums[i]) take = prev[sum - nums[i]];
                
                // not take
                int notTake = prev[sum];
                
                curr[sum] =  (take + notTake);
            }
            prev = curr.clone();
        }
        return prev[targetSum];
    }
};