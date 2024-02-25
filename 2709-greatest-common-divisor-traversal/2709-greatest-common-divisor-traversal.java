class Solution {
    public static int MAX = (int)1e5 + 5;
    public static boolean[] prime = new boolean[MAX];
    public static int[] spf = new int[MAX];
    public static int count = 0;

    public void sieve() {
        Arrays.fill(prime, true);
        for(int i = 0; i < MAX; i++){
            spf[i] = i;
        }

        prime[0] = prime[1] = false;

        for(int i = 2; i * i < MAX; i++){
            if(prime[i]) {
                for(int j = i * i; j < MAX; j+=i){
                    if(prime[j]) spf[j] = i;
                    prime[j] = false;
                }
            }
        }
    }

    public List<Integer> getFactorization(int x) {
        List<Integer> ret = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        while(x != 1) {
            map.put(spf[x], map.getOrDefault(spf[x], 0) + 1);
            x = x / spf[x];
        }

        for(int key : map.keySet()) ret.add(key);
        return ret;
    }

    public boolean canTraverseAllPairs(int[] nums) {
        if(!prime[2]) sieve();

        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(i, getFactorization(nums[i]));
        }

        HashMap<Integer, List<Integer>> rmap = new HashMap<>();

        for(int key : map.keySet()) {
            for(int prime : map.get(key)) {
                rmap.putIfAbsent(prime, new ArrayList<>());
                rmap.get(prime).add(key);
            }
        }

        HashMap<Integer, List<Integer>> gr = new HashMap<>();
        for(int key : rmap.keySet()) {
            List<Integer> keys = rmap.get(key);
            if(keys.size() <= 1) continue;

            for(int i = 1; i < keys.size(); i++) {
                int u = keys.get(i - 1);
                int v = keys.get(i);

                gr.putIfAbsent(u, new ArrayList<>());
                gr.putIfAbsent(v, new ArrayList<>());
                gr.get(u).add(v);
                gr.get(v).add(u);
            }
        }

        boolean[] vis = new boolean[n];
        count = 0;
        dfs(0, gr, vis);
        return count == n;
    }

    public void dfs(int u, HashMap<Integer, List<Integer>> gr, boolean[] vis) {
        vis[u] = true;
        count++;
        for(int v : gr.getOrDefault(u, new ArrayList<>())) {
            if(!vis[v]) {
                dfs(v, gr, vis);
            }
        }
    }
}
