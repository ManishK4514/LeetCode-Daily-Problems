class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        List<String> ans = new ArrayList<>();
        for(String word : words){
            int n = word.length();
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for(int i = 0; i < n; i++){
                if(dp[i] == 0) continue;
                for(int j = i + 1; j <= n; j++){
                    if(j - i < n && map.containsKey(word.substring(i, j))){
                        dp[j] = 1;
                    }
                }
                if(dp[n] != 0){
                    ans.add(word);
                    break;
                }
            }
        }
        return ans;
    }
}