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
    public void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
    
            start++;
            end--;
        }
    }
	public int perfectSum(int[] arr,int n, int target) {
	    if(arr[0] == 0) reverseArray(arr, 0, arr.length - 1);
	    
	    int mod = (int)(1e9 + 7);
	    
	    int[] prev = new int [target + 1];
	    int[] curr = new int[target + 1];
	    
	    prev[0] = curr[0] = 1;
	    
	    if(arr[0] <= target) prev[arr[0]] = 1;
	    
	    for(int i = 1; i < n; i++){
	        for(int sum = 0; sum <= target; sum++){
	            // take
	            int take = 0;
	            if(sum >= arr[i]) take = prev[sum - arr[i]];
        
                // notTake
                int notTake = prev[sum];
                
                curr[sum] = ((take % mod) + (notTake % mod)) % mod;
	        }
	        prev = curr.clone();
	    }
	    
	    return prev[target] % mod;
	} 
}