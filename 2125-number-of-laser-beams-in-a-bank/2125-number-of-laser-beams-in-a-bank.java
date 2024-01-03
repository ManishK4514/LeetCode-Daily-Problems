class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length, ans = 0, prev = 0;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < bank[i].length(); j++) {
                if(bank[i].charAt(j) == '1') count++;
            }
            ans += prev * count;
            if(count != 0) prev = count;
        }
        return ans;
    }
}