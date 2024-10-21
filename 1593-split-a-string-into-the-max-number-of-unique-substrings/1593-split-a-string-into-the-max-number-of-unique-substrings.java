class Solution {
    int ans = 0;
    public void solve(int idx, String s, Set<String> set){
        if(idx >= s.length()){
            ans = Math.max(ans, set.size());
            return;
        } 

        for(int i = idx ; i < s.length(); i++){
            String temp = s.substring(idx, i + 1);
            if(!set.contains(temp)){
                set.add(temp);
                solve(i + 1, s, set);
                set.remove(temp);
            }
        }
    }

    public int maxUniqueSplit(String s) {
        solve(0, s, new HashSet<>());
        return ans;
    }
}