class Solution {
    public int[] frequencySort(int[] nums) {
        int[] map = new int[202];
        int n = nums.length;
        for(int i = 0; i < n; i++) map[nums[i] + 100]++;
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) arr.add(nums[i]);
        Collections.sort(arr, (a, b)->{
            if(map[a + 100] == map[b + 100]) return b - a;
            return map[a + 100] - map[b + 100];
        });
        for(int i = 0; i < n; i++) nums[i] = arr.get(i);
        return nums;
    }
}