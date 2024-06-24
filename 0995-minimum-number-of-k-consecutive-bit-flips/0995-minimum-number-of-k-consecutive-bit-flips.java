class Solution {    
    public int minKBitFlips(int[] nums, int k) {
        int count = 0, n = nums.length;
        int[] dp = new int[n + 1];
        if(nums[0] == 0){
            dp[0] = 1; dp[k] = -1;
            count++;
        }
        for(int i = 1; i <= n - k; i++){
            dp[i] += dp[i - 1];
            if((dp[i] % 2 == 0 && nums[i] == 0) || (dp[i] % 2 != 0 && nums[i] == 1)){
                dp[i] += 1;
                dp[i + k] -= 1;
                count++;
            }
        }
        
        for(int i = n - k + 1; i < n; i++){
            if(i - 1 >= 0) dp[i] += dp[i - 1];
            if((dp[i] % 2 == 0 && nums[i] == 0) || (dp[i] % 2 != 0 && nums[i] == 1)){
                return -1;
            }            
        }
        return count;
    }
}