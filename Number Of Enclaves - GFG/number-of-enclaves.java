//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public void dfs(int row, int col, int n, int m, int[][] vis, int[][] grid, int[] delRow, int[] delCol){
        vis[row][col] = 1;
        for(int i = 0; i < 4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, n, m, vis, grid, delRow, delCol);
            }
        }
    }
    int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[] delRow = {0, -1, 0, 1};
        int[] delCol = {-1, 0, 1, 0};
        for(int i = 0; i < m; i++){
            if(vis[0][i] == 0 && grid[0][i] == 1){
                dfs(0, i, n, m, vis, grid, delRow, delCol);
            }
            if(vis[n - 1][i] == 0 && grid[n - 1][i] == 1){
                dfs(n - 1, i, n, m, vis, grid, delRow, delCol);
            }
        }
        for(int i = 0; i < n; i++){
            if(vis[i][0] == 0 && grid[i][0] == 1){
                dfs(i, 0, n, m, vis, grid, delRow, delCol);
            }
            if(vis[i][m - 1] == 0 && grid[i][m - 1] == 1){
                dfs(i, m - 1, n, m, vis, grid, delRow, delCol);
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}