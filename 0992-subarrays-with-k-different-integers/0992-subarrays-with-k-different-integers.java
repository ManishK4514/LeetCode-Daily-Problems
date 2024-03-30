class Solution {
    public int atMost(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, sum = 0, sum2 = 0;
        for(int j = 0; j < nums.length; j++){
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while(map.size() > k){
                map.put(nums[i], map.get(nums[i]) - 1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }
            sum += ((j - i) + 1);
        }
        return sum;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {        
        return atMost(nums, k) - atMost(nums, k - 1);
    }
}