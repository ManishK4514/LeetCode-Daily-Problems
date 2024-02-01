public class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);

        List<int[]> res = new ArrayList<>();
        int[] currArr;
        for (int i = 2; i < nums.length; i+=3) {
            if (nums[i] - nums[i - 1] <= k && nums[i - 1] - nums[i - 2] <= k && nums[i] - nums[i - 2] <= k) {
                currArr = new int[]{nums[i - 2], nums[i - 1], nums[i]};
                res.add(currArr);
            }
        }

        if (res.size() * 3 == nums.length) return res.toArray(new int[0][]);
        else return new int[0][];
    }
}