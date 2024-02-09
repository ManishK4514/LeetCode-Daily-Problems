class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];
        int lastIdx = 0, size = 0;

        for(int i = 0; i < n; i++){
            hash[i] = i;
            for(int prevIdx = 0; prevIdx < i; prevIdx++){
                if(nums[i] % nums[prevIdx] == 0 && dp[i] < (1 + dp[prevIdx])){
                    dp[i] = dp[prevIdx] + 1;
                    hash[i] = prevIdx;
                }
            }
            if(size < dp[i]){
                size = dp[i];
                lastIdx = i;
            }            
        }

        List<Integer> ans = new ArrayList<>();

        ans.add(nums[lastIdx]);

        while(hash[lastIdx] != lastIdx){
            lastIdx = hash[lastIdx];
            ans.add(nums[lastIdx]);
        }

        return ans;
    }
}