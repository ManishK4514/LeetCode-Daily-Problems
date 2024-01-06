class Solution {
    public int search(int[][] jobs, int l, int target) {
        int r = jobs.length - 1;

        while(l <= r) {
            int mid = l + (r - l)/2;
            if(jobs[mid][0] >= target) r = mid - 1;
            else l = mid + 1;
        }

        return l;
    }

    public int helper(int i, int[][] jobs, int[] dp) {
        if(i == jobs.length) return 0;

        if(dp[i] != -1) return dp[i];

        int pick = 0;
        int nextIdx = search(jobs, i, jobs[i][1]);
        if(nextIdx > i) {
            pick = jobs[i][2] + helper(nextIdx, jobs, dp);
        }

        int notPick = helper(i + 1, jobs, dp);

        return dp[i] = Math.max(pick, notPick);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];

        for(int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b)->{
            if(a[0] == b[0]) {
                if(a[1] == b[1]) return a[2] - b[2];
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return helper(0, jobs, dp);
    }
}