class Solution {
    public String kthDistinct(String[] arr, int k) {
        int n = arr.length;
        HashMap<String, Integer> map = new HashMap<>();

        for(String str : arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for(int i = 0; i < n; i++) {
            if(map.get(arr[i]) == 1) k--;
            if(k == 0) return arr[i];
        }

        return "";
    }
}