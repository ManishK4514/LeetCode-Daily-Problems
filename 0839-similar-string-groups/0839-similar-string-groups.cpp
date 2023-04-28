class Solution {
public:
    void dfs(vector<string>& strs, vector<int>& vis, int idx, int n){
        vis[idx] = 1;
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                string str = strs[idx];
                string curr = strs[i];
                int count = 0;
                for(int j = 0; j < str.length(); j++){
                    if(str[j] != curr[j]) count++;
                }
                if(count == 2 || count == 0){
                    dfs(strs, vis, i, n);
                }
            }
        }
    }
    int numSimilarGroups(vector<string>& strs) {
        int n = strs.size();
        vector<int> vis(n, 0);
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                ans++;
                dfs(strs, vis, i, n);
            }
        }
        return ans;
    }
};