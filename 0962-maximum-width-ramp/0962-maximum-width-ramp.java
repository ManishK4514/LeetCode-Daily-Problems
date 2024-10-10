class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            if(st.isEmpty() || nums[st.peek()] < nums[i]){
                st.push(i);
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                max = Math.max(max, st.peek() - i);
                st.pop();
            }
            if(st.size() == 0) break;
        }
        return max;
    }
}