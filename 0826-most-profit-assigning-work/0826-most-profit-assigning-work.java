class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int search(Pair[] arr, int target){
        int l = 0, h = arr.length - 1;
        while(l <= h){
            int mid = l + (h - l)/2;
            if(arr[mid].first <= target) l = mid + 1;
            else h = mid - 1;
        }
        return h;
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++) arr[i] = new Pair(difficulty[i], i);
        Arrays.sort(arr, (a, b)->{return a.first - b.first;});
        int[] newProfit = new int[n];
        int max = profit[arr[0].second];
        newProfit[0] = max;
        for(int i = 1; i < n; i++){
            max = Math.max(max, profit[arr[i].second]);
            newProfit[i] = max;
        }

        int ans = 0;

        // Assigning Work
        for(int i = 0; i < worker.length; i++){
            int idx = search(arr, worker[i]);
            if(idx >= 0 && idx < n) ans += newProfit[idx];
        }
        return ans;
    }
}