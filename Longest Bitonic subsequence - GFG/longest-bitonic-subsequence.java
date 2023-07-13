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
    public int LongestBitonicSequence(int[] nums)
    {
        int n = nums.length;
        int[] lis = new int[n];
        int[] lds = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        for(int i = 0; i < n; i++){
            for(int prevIdx = 0; prevIdx < i; prevIdx++){
                
                if(nums[i] > nums[prevIdx] && lis[i] < lis[prevIdx] + 1){
                    lis[i] = lis[prevIdx] + 1;
                }
            }
        }
        
        for(int i = n - 1; i >= 0; i--){
            for(int prevIdx = n - 1; prevIdx > i; prevIdx--){
                
                if(nums[i] > nums[prevIdx] && lds[i] < lds[prevIdx] + 1){
                    lds[i] = lds[prevIdx] + 1;
                }
            }
        }
        
        int max = 1;
        
        // System.out.println(Arrays.toString(lis));
        // System.out.println(Arrays.toString(lds));
        
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[i] > nums[j]){
                     max = Math.max(max, lis[i] + lds[j]);
                 }
            }
        }
        
        max = Math.max(max, Math.max(lis[n - 1], lds[0]));
        
        return max;
    }
}