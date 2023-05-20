class Solution {
    public double dfs(HashMap<String, HashMap<String, Double>> map, String src, String dst, HashSet<String> vis, double val){
        if(src.equals(dst)) return val;
        vis.add(src);
        for(Map.Entry<String, Double> it : map.get(src).entrySet()){
            if(!vis.contains(it.getKey())){
                double ans = dfs(map, it.getKey(), dst, vis, it.getValue());
                if(ans != -1) return ans * val;
            }
        }

        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        int idx = 0;
        for(int i = 0; i < equations.size(); i++){
            map.putIfAbsent(equations.get(i).get(0), new HashMap<>());
            map.putIfAbsent(equations.get(i).get(1), new HashMap<>());

            map.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
            map.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1/values[i]);
        }
        
        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            if(!map.containsKey(queries.get(i).get(0)) || !map.containsKey(queries.get(i).get(1))){
                res[i] = -1.0;
            }
            else res[i] = dfs(map, queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), 1.0);
        }
        return res;
    }
}