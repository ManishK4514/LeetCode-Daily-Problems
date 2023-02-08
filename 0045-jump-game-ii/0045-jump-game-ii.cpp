class Solution {
public:
    int jump(vector<int>& nums) {
        int farthest = 0, jumps = 0, curr = 0;
        for(int i = 0; i < nums.size() - 1; i++){
            farthest = max(farthest, i + nums[i]);

            if(i == curr){
                jumps++;
                curr = farthest;
            }
        }
        return jumps;
    }
};