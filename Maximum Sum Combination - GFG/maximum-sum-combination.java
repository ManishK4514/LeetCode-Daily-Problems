//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static void reverse(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n/2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = temp;
        }
    }
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        Arrays.sort(A);
        reverse(A);
        Arrays.sort(B);
        reverse(B);
        
        List<Integer> ans = new LinkedList<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                return (A[y[0]] + B[y[1]]) - (A[x[0]] + B[x[1]]);
            }
        });

        
        for(int i = 0; i < N; i++) {
            pq.add(new int[]{i, 0});
        }
        
        while(K-->0) {
            int[] curr = pq.remove();
            
            ans.add(A[curr[0]] + B[curr[1]]);
            
            if(curr[1] + 1 < N) {
                pq.add(new int[]{curr[0], curr[1] + 1});
            }
        }
        
        return ans;
    }
}
