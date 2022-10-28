class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        int[] ans = new int[(nums.length - k) + 1];
        int left = 0, right = 0, index = 0;
        while(right < k){
            if(list.isEmpty()){
                list.add(nums[right]);
            }
            else{
                while(!list.isEmpty() && nums[right] > list.getLast()){
                    list.removeLast();
                }
                list.addLast(nums[right]);
            }
            right++;
        }
        ans[index++] = list.getFirst();
        if(!list.isEmpty() && list.getFirst() == nums[left]){
            list.removeFirst();
        }
        left++;
        while(right < nums.length){
            if(list.isEmpty()){
                list.add(nums[right]);
            }
            else{
                while(!list.isEmpty() && nums[right] > list.getLast()){
                    list.removeLast();
                }
                list.addLast(nums[right]);
            }
            ans[index++] = list.getFirst();
            // Removing calculations of left element
            if(!list.isEmpty() && list.getFirst() == nums[left]){
                list.removeFirst();
            }
            right++;
            left++;
        }
        return ans;
    }
}