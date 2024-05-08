class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[] map = new int[1000001];
        int n = score.length, m = map.length;
        
        for(int i = 0; i < n; i++) map[score[i]]++;
        for(int i = m - 2; i >= 0; i--) map[i] += map[i + 1];

        String[] ans = new String[n];

        for(int i = 0; i < n; i++) {
            if(map[score[i]] == 1) ans[i] = "Gold Medal";
            else if(map[score[i]] == 2) ans[i] = "Silver Medal";
            else if(map[score[i]] == 3) ans[i] = "Bronze Medal";
            else ans[i] = map[score[i]] + "";
        }

        return ans;
    }
}