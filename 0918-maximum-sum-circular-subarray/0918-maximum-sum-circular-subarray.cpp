class Solution {
public:
    int kadanes(vector<int>& nums){
        int n = nums.size();
        int maxSum = INT_MIN, currSum = 0;
        for(int i = 0; i < n; i++){
            currSum += nums[i];
            if(maxSum < currSum){
                maxSum = currSum;
            }
            if(currSum < 0) currSum = 0;
        }
        return maxSum;
    }
    int maxSubarraySumCircular(vector<int>& nums) {
        int n = nums.size();
        int x = kadanes(nums);
        int y = 0;
        
        for(int i = 0; i < n; i++){
            // calculating total sum before inverting sum
            y += nums[i];
            // invert sign of array elements
            nums[i] *= -1;
        }
        int z = kadanes(nums);
        if((y -(-z)) == 0) return x;
        return max(x, (y -(-z)));
    }
};