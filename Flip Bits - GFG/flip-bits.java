//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maxOnes(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    public static int kadanesAlgo(int[] arr) {
        int maxSum = 0, currSum = 0;
        for(int it : arr) {
            currSum += (it == 0) ? 1 : -1;
            if(currSum < 0) currSum = 0;
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
    public static int maxOnes(int a[], int n) {
        int totalSum = 0;
        
        for(int it : a) totalSum += it;
        
        return totalSum + kadanesAlgo(a);
    }
}
