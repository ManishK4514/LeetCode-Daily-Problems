class Solution {
public:
    int minimumDeviation(vector<int>& nums) {
        priority_queue<int> pq;
        int mini = INT_MAX;
        for(int i = 0; i < nums.size(); i++){
            if(nums[i] % 2 == 0){
                pq.push(nums[i]);
                mini = min(mini, nums[i]);
            }
            else{
                pq.push(nums[i] * 2);
                mini = min(mini, nums[i] * 2);
            }
        }
        int ans = INT_MAX;
        while(!pq.empty()){
            int top = pq.top();
            pq.pop();
            ans = min(ans, top - mini);
            if(top % 2 != 0) break;
            top /= 2; 
            mini = min(mini, top);
            pq.push(top);
        }   
        return ans;
    }
};