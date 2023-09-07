//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair {
    int steps;
    int x;
    
    Pair(int steps, int x) {
        this.steps = steps;
        this.x = x;
    }
}

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        int n = arr.length;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, start));
        
        int[] vis = new int[100001];
        vis[start] = 1;
        
        while(!q.isEmpty()) {
            Pair p = q.remove();
            
            int steps = p.steps;
            int x = p.x;
            
            if(x == end) return steps;
            
            for(int i = 0; i < n; i++) {
                int curr = (x * arr[i]) % 100000;
                if(vis[curr] == 0) {
                    vis[curr] = 1;
                    q.add(new Pair(steps + 1, curr));
                }
            }
        }
        
        return -1;
    }
}
