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
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String s)
    {
        int n = s.length();
        int[] dp = new int[n + 1];

        boolean[][] isPalindrome = new boolean[n][n];

        for(int g = 0; g < s.length(); g++){
            for(int i = 0, j = g; j < isPalindrome.length; i++, j++){
                if(g == 0){
                    isPalindrome[i][j] = true;
                }
                else if(g == 1){
                    isPalindrome[i][j] = s.charAt(i) == s.charAt(j);
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1] == true){
                        isPalindrome[i][j] = true;
                    }
                }
            }
        }

        for(int i = n - 1; i >= 0; i--){
            int min = (int) 1e9;
                
            for(int k = i; k < n; k++){
                // partition
                if(isPalindrome[i][k]){
                    min = Math.min(min, 1 + dp[k + 1]);
                }
            }
           
            dp[i] = min;
        }

        return dp[0] - 1;
    }
}