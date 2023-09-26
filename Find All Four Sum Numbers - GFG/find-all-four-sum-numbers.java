//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(set);
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int k = j + 1, l = n - 1;
                while(k < l){
                    long currSum = (nums[i] * 1L) + (nums[j] * 1L) + (nums[k] * 1L) + (nums[l] * 1L);
                    if(currSum == target * 1L){
                        ArrayList<Integer> ls = new ArrayList<>();
                        ls.add(nums[i]);
                        ls.add(nums[j]);
                        ls.add(nums[k]);
                        ls.add(nums[l]);
                        if(!set.contains(ls)) {
                            ans.add(ls);
                        }
                        set.add(ls);
                        k++; l--;
                    }
                    else if(currSum < target * 1L) k++;
                    else l--;
                }
            }      
        }
        return ans;
    }
}