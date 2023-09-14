class Solution {
    public boolean dfs(String src, HashMap<String, List<String>> adj, List<String> ans, int totalTickets, HashMap<String, List<Integer>> vis) {
        if(ans.size() == totalTickets + 1) return true;
        if(!adj.containsKey(src)) return false;
        
        List<Integer> srcVis = vis.get(src);

        for(int i = 0; i < adj.get(src).size(); i++) {
            String it = adj.get(src).get(i);

            if (srcVis.get(i) == 0) {
                ans.add(it);
                srcVis.set(i, 1);
                if(dfs(it, adj, ans, totalTickets, vis)) return true; 
                ans.remove(ans.size() - 1);
                srcVis.set(i, 0);
            }
        }
        return false;
    }
    
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> adj = new HashMap<>();

        for(List<String> ticket : tickets) {
            adj.putIfAbsent(ticket.get(0), new ArrayList<>());
            adj.get(ticket.get(0)).add(ticket.get(1));
        }

        for(Map.Entry<String, List<String>> entry : adj.entrySet()) {
            Collections.sort(entry.getValue());
        }
        
        List<String> ans = new LinkedList<>();
        ans.add("JFK");

        HashMap<String, List<Integer>> vis = new HashMap<>(); 
        for (String key : adj.keySet()) {
            List<Integer> zerosList = new ArrayList<>();
            int size = adj.get(key).size();
            for (int i = 0; i < size; i++) {
                zerosList.add(0);
            }
            vis.put(key, zerosList);
        }

        dfs("JFK", adj, ans, tickets.size(), vis); 
        return ans;
    }
}
