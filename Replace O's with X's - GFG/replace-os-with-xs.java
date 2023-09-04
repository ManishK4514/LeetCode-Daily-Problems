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
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static char[][] fill(int n, int m, char a[][]) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && a[i][j] == 'O') {
                    dfs(i, j, a);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'O') {
                    a[i][j] = 'X';
                } else if (a[i][j] == 'V') {
                    a[i][j] = 'O';
                }
            }
        }
        
        return a;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public static void dfs(int i, int j, char a[][]) {
        if (i < 0 || i >= a.length || j < 0 || j >= a[0].length || a[i][j] != 'O') {
            return;
        }

        a[i][j] = 'V';

        // Visit neighboring cells.
        dfs(i + 1, j, a);
        dfs(i - 1, j, a);
        dfs(i, j + 1, a);
        dfs(i, j - 1, a);
    }
}