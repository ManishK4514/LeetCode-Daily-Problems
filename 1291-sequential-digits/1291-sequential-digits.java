class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int minLength = (low + "").length();
        int maxLength = (high + "").length();

        List<Integer> ans = new ArrayList<>();

        for(int len = minLength; len <= maxLength; len++) {
            for(int i = len; i <= 9; i++) {
                int currNum = 0;
                for(int j = i - len + 1; j <= i; j++) {
                    currNum = currNum * 10 + j;                    
                }
                if(currNum >= low && currNum <= high) ans.add(currNum);
            }
        }

        return ans;
    }
}