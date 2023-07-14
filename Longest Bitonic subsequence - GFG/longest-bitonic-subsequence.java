//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);

        for(int i = 0; i < n; i++){
            for(int prevIdx = 0; prevIdx < i; prevIdx++){
                
                if(nums[i] > nums[prevIdx] && dp1[i] < dp1[prevIdx] + 1){
                    dp1[i] = dp1[prevIdx] + 1;
                }
            }
        }
        
        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);
        
        int max = 1;
        
        for(int i = n - 1; i >= 0; i--){
            for(int prevIdx = n - 1; prevIdx > i; prevIdx--){
                
                if(nums[i] > nums[prevIdx] && dp2[i] < dp2[prevIdx] + 1){
                    dp2[i] = dp2[prevIdx] + 1;
                }
            }
            max = Math.max(max, dp1[i] + dp2[i] - 1);
        }
        
        return max;
    }
}