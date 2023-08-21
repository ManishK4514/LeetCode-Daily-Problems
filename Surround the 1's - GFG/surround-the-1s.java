//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int  Count(int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int ans = 0;
        
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(matrix[row][col] == 0) continue;
                
                int cnt = 0;
                
                for(int delRow = -1; delRow <= 1; delRow++) {
                    for(int delCol = -1; delCol <= 1; delCol++) {
                        if(delRow == 0 && delCol == 0) continue;
                        
                        int nrow = row + delRow;
                        int ncol = col + delCol;
                        if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && matrix[nrow][ncol] == 0){
                            cnt++;
                        }
                        
                    }
                }
                
                if(cnt > 0 && cnt % 2 == 0) ans++;
            }
        }
        return ans;
    }
}