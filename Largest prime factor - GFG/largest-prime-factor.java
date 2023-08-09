//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.largestPrimeFactor(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long largestPrimeFactor(int N) {
        long ans = 0;
        long i = 2;
        for(i = 2; i <= Math.sqrt(N); i++){
            while(N % i == 0){
                N/=i;
            }
            ans = Math.max(ans, i);
        }
        if(N > 1){
            ans = N;
        }
        return ans;
    }
}