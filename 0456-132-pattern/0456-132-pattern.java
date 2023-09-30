class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length, thirdElement = Integer.MIN_VALUE;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = n - 1; i >= 0; i--) {
            if(thirdElement > nums[i]) return true;

            while(!st.isEmpty() && st.peek() < nums[i]) {
                thirdElement = st.pop();
            }

            st.push(nums[i]);         
        }

        return false;
    }
}