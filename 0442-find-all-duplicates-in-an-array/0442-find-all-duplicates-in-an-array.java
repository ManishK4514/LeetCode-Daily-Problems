class Solution {
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int j = nums[i] - 1;
            while(nums[i] != nums[j]) {                
                swap(i, j, nums);
                j = nums[i] - 1;
            }
        }

        List<Integer> ls = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1){
                ls.add(nums[i]);
            }
        }
        return ls;
    }
}