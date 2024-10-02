class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = arr.clone();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        Arrays.sort(temp);
        int rank = 1, n = arr.length;
        for(int it : temp) {
            if(!map.containsKey(it)) map.put(it, rank++);            
        }

        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }
}