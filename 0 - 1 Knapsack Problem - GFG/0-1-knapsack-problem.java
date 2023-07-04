//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    
    public static int knapSack(int W, int wt[], int val[], int n){ 
        int[] prev = new int[W + 1];
        int[] curr = new int[W + 1];
        
        for(int i = wt[0]; i <= W; i++){
            prev[i] = val[0];
        }
    
        for(int i = 1; i < n; i++){
            for(int cap = 0; cap <= W; cap++){
                // take
                int take = Integer.MIN_VALUE;
                if(cap >= wt[i]) take = val[i] + prev[cap - wt[i]];
                
                // notTake
                int notTake = prev[cap];
                
                curr[cap] = Math.max(take, notTake);
            }
            prev = curr.clone();
        }
        return prev[W];
    } 
}


