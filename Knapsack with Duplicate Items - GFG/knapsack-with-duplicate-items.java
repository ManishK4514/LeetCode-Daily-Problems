//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int knapSack(int N, int W, int val[], int wt[]) {
        int[] prev = new int[W + 1];
        int[] curr = new int[W + 1];
        
        for(int i = wt[0]; i <= W; i++){
            prev[i] = ((int) i/wt[0]) * val[0];
        }
        
        for(int i = 1; i < N; i++){
            for(int cap = 0; cap <= W; cap++){
                // take
                int take = Integer.MIN_VALUE;
                if(wt[i] <= cap) take = val[i] + curr[cap - wt[i]];
                
                // not take
                int notTake = prev[cap];
                
                curr[cap] = Math.max(take, notTake);
            }
            prev = curr.clone();
        }
        return prev[W];
    }
}