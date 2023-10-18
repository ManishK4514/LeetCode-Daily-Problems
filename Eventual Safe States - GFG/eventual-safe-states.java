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
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int n, List<List<Integer>> adj) {

        int[] indegree = new int[n];
        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjRev.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++){
            for(int it : adj.get(i)){
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.remove();
            ans.add(node);
            for(int it : adjRev.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
