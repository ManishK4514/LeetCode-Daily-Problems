class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer, Long> map = new HashMap<>();
        long ans = 0, mod = (long)(1e9 + 7);
        for(int i = 0; i < arr.length; i++){
            long count = 1;
            int root = (int)Math.sqrt(arr[i]);
            for(int j = 0; j < i && arr[j] <= root; j++){
                int k = arr[j];
                if(arr[i] % k == 0){
                    if(map.containsKey(arr[i]/k) && arr[i]/k != k){
                        count += 2 * map.get(k) * map.get(arr[i]/k);
                    }
                    else if(map.containsKey(arr[i]/k) && arr[i]/k == k){
                        count += map.get(k) * map.get(k);
                    }
                }
            }
            map.put(arr[i], count);
            ans = (ans + map.get(arr[i])) % mod;
        }
        return (int) (ans % mod);
    }
}