class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < n; i++){
            if(manager[i] != -1){
                adj.get(i).add(new Pair(informTime[i], manager[i]));
                adj.get(manager[i]).add(new Pair(informTime[i], i));
            }
        }
        int[] vis = new int[n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(informTime[headID], headID));
        vis[headID] = 1;
        int ans = 0;
        while(!q.isEmpty()){
            int dst = q.peek().first;
            int node = q.peek().second;
            q.remove();
            
            ans = Math.max(dst, ans);

            for(Pair it : adj.get(node)){
                if(vis[it.second] == 0){
                    vis[it.second] = 1;
                    q.add(new Pair(dst + informTime[it.second], it.second));
                }
            }
        }
        return ans;
    }
}