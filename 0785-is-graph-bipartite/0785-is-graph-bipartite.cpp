class Solution {
public:
    bool dfs(int start, int n, vector<vector<int>>& graph,vector<int>& color, int currCol){      
        color[start] = currCol;
        for(auto node : graph[start]){
            if(color[node] == -1){
                if(dfs(node, n, graph, color, 1 - currCol) == false){
                    return false;
                }
            }
            else if(color[node] == currCol) return false;
        }
        return true;
    }
    bool isBipartite(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<int> color (n, -1);
        for(int i = 0; i < n; i++){
            if(color[i] == -1){
                if(dfs(i, n, graph, color, 0) == false){
                    return false;
                }
            }
        }
        return true;
    }
};