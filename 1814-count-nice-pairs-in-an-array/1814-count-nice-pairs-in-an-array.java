class Solution {
    public static int reverseDigits(int num) {
        int reversedNum = 0;

        while (num != 0) {
            int digit = num % 10; 
            reversedNum = reversedNum * 10 + digit; 
            num /= 10; 
        }

        return reversedNum;
    }
    public int countNicePairs(int[] nums) {
        int n = nums.length;
        long ans = 0, mod = (long)(1e9 + 7);

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int currVal = nums[i] - reverseDigits(nums[i]);
            if(map.containsKey(currVal)){
               ans = (ans + map.get(currVal)) % mod;
            }
            map.put(currVal, map.getOrDefault(currVal, 0) + 1);
        }

        return (int)(ans % mod);
    }
}