class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += nums[i] % k;
            int target = sum % k;

            if(map.containsKey(target)) {
                if(i - map.get(target) > 1) return true;
            }

            map.putIfAbsent(target, i);
        }

        return false;
    }
}