class Solution {    
    public int helper(int i,int j,List<Integer> cuts_list, int[][] dp){
        if (i>j) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        int mini = Integer.MAX_VALUE;
        for (int ind=i;ind<=j;ind++){
            int steps = cuts_list.get(j+1) - cuts_list.get(i-1) 
                + helper(i,ind-1,cuts_list, dp) 
                + helper(ind+1,j,cuts_list, dp); 
            mini = Math.min(steps,mini);
        }
        return dp[i][j] = mini;
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int c = cuts.length;
        List<Integer> newCuts = new ArrayList<>();
        newCuts.add(0);
        for (int i=0;i<c;i++) newCuts.add(cuts[i]);
        newCuts.add(n);
        int[][] dp = new int[c+2][c+2];
        for (int i=0;i<c+2;i++) Arrays.fill(dp[i],-1);
        return helper(1,c,newCuts, dp);
    }    
}