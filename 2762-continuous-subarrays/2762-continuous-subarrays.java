class Solution {
    public boolean isValid(TreeMap<Integer, Integer> map){
        int l = map.firstEntry().getKey();
        int r = map.lastEntry().getKey();
        return r - l <= 2;
    }
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long count = 0;

        int l = 0;
        int r = 0;      
        
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            
            while (!isValid(map)) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
                count += n - r;
            }
            r++;
        }
        
        long total = (n * 1L * (n + 1))/(2 * 1L);

        return total - count;
    }
}