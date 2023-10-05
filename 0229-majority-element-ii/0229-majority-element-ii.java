class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = -1, num2 = 0, cnt1 = 0, cnt2 = 0, n = nums.length;

        for(int i = 0; i < n; i++) {
            if(num1 == nums[i]) cnt1++;
            else if(num2 == nums[i]) cnt2++;
            else if(cnt1 == 0) {
                num1 = nums[i];
                cnt1 = 1;
            }
            else if(cnt2 == 0) {
                num2 = nums[i];
                cnt2 = 1;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }

        int count1 = 0, count2 = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] == num1) count1++;
            else if(nums[i] == num2) count2++;
        }

        List<Integer> ans = new ArrayList<>();

        if(count1 > n/3) ans.add(num1);
        if(count2 > n/3) ans.add(num2);

        return ans;
    }
}