class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Pair(nums2[i], nums1[i]);
        }
        Arrays.sort(arr, (a, b)->{
          return b.first - a.first;
        });
        long currScore = 0, maxScore = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            currScore += arr[i].second;
            pq.add(arr[i].second);

            if(i >= k - 1){
                maxScore = Math.max(maxScore, currScore * arr[i].first);
                currScore -= pq.remove();
            }
        }
        return maxScore;
    }
}