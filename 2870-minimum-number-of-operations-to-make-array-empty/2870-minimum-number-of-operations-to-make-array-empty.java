class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int n = nums.length, ans = 0;
        
        for(int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for(int key : map.keySet()) {
            if(map.get(key) == 1) return -1; 
            ans += map.get(key)/3;
            if(map.get(key) % 3 != 0) ans++;
        }
        
        return ans;
    }
}