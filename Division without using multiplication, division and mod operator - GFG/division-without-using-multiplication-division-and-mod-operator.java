//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GfG {
    

	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String S[] = br.readLine().split(" ");
            
            long a = Long.parseLong(S[0]);
            
            long b = Long.parseLong(S[1]);
	       
	    	Solution ob = new Solution();
           
            System.out.println(ob.divide(a,b));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long divide(long dividend, long divisor)
    {
        boolean sign = (dividend>=0) == (divisor>=0) ? true:false;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        long result = 0;
        while(dividend - divisor >= 0){
            long count = 0;
            while(dividend - (divisor << 1 << count) >= 0){
                count++;
            }
            result += 1 << count;
            dividend -= divisor << count;
        }
        return sign?result:-result;
    }
}