//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        int[] curr = new int[n + 1];
        
        for(int i = 0; i <= n; i++){
            curr[i] = i * price[0];
        }
        
        for(int i = 1; i < n; i++){
            for(int length = 0; length <= n; length++){
                // take
                int take = Integer.MIN_VALUE;
                if(i + 1 <= length) take = price[i] + curr[length - (i + 1)];
                
                // not take
                int notTake = curr[length];
                
                curr[length] = Math.max(take, notTake);
            }
        }
        
        return curr[n];
    }   
}