//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            
            long a[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.countSubArrayProductLessThanK(a, n, k));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public int countSubArrayProductLessThanK(long nums[], int n, long k) {
        long count = 0;

        int l = 0;
        int r = 0;      
        
        long product = 1;

        while (r < n) {
            product *= nums[r];
            
            while (product >= k) {
                if(l == r) {
                    l++;
                    product = 1;
                    count += n - r;
                    break;
                }
                product /= nums[l++];
                count += n - r;
            }
            r++;
        }
        
        
        long total = (n * 1L * (n + 1))/(2 * 1L);

        return (int)(total - count);
    }
}