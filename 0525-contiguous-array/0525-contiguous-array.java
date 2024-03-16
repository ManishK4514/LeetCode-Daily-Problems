class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int runningSum = 0, res = 0, n = nums.length;
        map.put(runningSum, -1);

        for(int i = 0; i < n; i++) {
            runningSum += nums[i] == 0 ? -1 : 1;
            if(map.containsKey(runningSum)) res = Math.max(res, i - map.get(runningSum));
            else map.put(runningSum, i);
        }

        return res;
    }
}