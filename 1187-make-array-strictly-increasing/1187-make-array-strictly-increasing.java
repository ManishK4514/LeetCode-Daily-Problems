class Solution {
    public static int search(int[] arr, int target){
        int l = 0, h = arr.length - 1;
        while(l <= h){
            int mid = l + (h - l)/2;
            if(arr[mid] > target) h = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
    public int helper(int[] arr1, int idx, int prev, int[] arr2, HashMap<Pair<Integer, Integer>, Integer> map){
        if(idx == arr1.length) return 0;
        if(map.containsKey(new Pair(idx, prev))) return map.get(new Pair(idx, prev));
        int currInd = search(arr2, prev);
        int min = (int)1e8;
        // move
        if(arr1[idx] > prev) min = Math.min(min, helper(arr1, idx + 1, arr1[idx], arr2, map));

        // assign
        if(currInd < arr2.length) min = Math.min(min, 1 + helper(arr1, idx + 1, arr2[currInd], arr2, map));
        map.put(new Pair(idx, prev), min);
        return min;
    }
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        int ans = helper(arr1, 0, Integer.MIN_VALUE, arr2, map);
        return ans == 1e8 ? -1 : ans;
    }
}