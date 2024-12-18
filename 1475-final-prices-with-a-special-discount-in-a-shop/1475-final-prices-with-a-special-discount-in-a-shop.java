class Solution {
    public int[] nextSmaller(int[] prices, int n) {
        int[] nums = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && prices[st.peek()] > prices[i]) st.pop();
            if(st.isEmpty()) nums[i] = -1;
            else nums[i] = st.peek();
            st.push(i);
        }

        return nums;
    }
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] nums = nextSmaller(prices, n);

        for(int i = 0; i < n; i++) {
            if(nums[i] == -1) nums[i] = prices[i];
            else nums[i] = prices[i] - prices[nums[i]];
        }

        return nums;
    }
}