//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{
    public int countPartitions(int n, int d, int arr[]){
        int totalSum = 0, mod = (int) (1e9 + 7);
        for(int i = 0; i < n; i++) totalSum += arr[i];
        
        if(totalSum - d < 0 || ((totalSum - d) % 2) != 0) return 0;
        
        int targetSum = (totalSum - d)/2;
        
        int[] prev = new int[targetSum + 1];
        int[] curr = new int[targetSum + 1];
        
        if(arr[0] == 0) prev[0] = 2;
        else prev[0] = 1;
        
        if(arr[0] != 0 && arr[0] <= targetSum) prev[arr[0]] = 1;
        
        for(int i = 1; i < n; i++){
            for(int sum = 0; sum <= targetSum; sum++){
                // take
                int take = 0;
                if(sum >= arr[i]) take = prev[sum - arr[i]];
                
                // not take
                int notTake = prev[sum];
                
                curr[sum] =  (take + notTake) % mod;
            }
            prev = curr.clone();
        }
        return prev[targetSum];
    }
}