class Solution {
    public int minChanges(String s) {
        int n = s.length(), ans = 0;

        for(int i = 1; i < n; i += 2) {
            char ch = s.charAt(i);            
            if(ch != s.charAt(i - 1)) ans++;
        }

        return ans;
    }
}