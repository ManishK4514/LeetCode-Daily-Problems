class Solution {
    public int helper(int idx, int[][] requests, int[] indegree, int count, int n){
        if(idx == requests.length){
            for(int i = 0; i < n; i++){
                if(indegree[i] != 0) return 0;
            }
            return count;
        }

        // take
        indegree[requests[idx][0]]--;
        indegree[requests[idx][1]]++;
        int take = helper(idx + 1, requests, indegree, count + 1, n);
        indegree[requests[idx][0]]++;
        indegree[requests[idx][1]]--;

        // notTake
        int notTake = helper(idx + 1, requests, indegree, count, n);

        return Math.max(take, notTake);
    }
    public int maximumRequests(int n, int[][] requests) {
        int[] indegree = new int[n];
        return helper(0, requests, indegree, 0, n);
    }
}