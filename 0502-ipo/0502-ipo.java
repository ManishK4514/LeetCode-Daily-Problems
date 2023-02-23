class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Pair(profits[i], capital[i]);
        }
        Arrays.sort(arr, (a, b)->{
            if(a.second != b.second){
                return a.second - b.second;
            }
            return b.first - a.first;
        });
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->{
            return b.first - a.first;
        });
        int i = 0;
        while(k-->0){
            while(i < n && arr[i].second <= w){
                pq.add(new Pair(arr[i].first, arr[i].second));  
                i++;
            }
            if(!pq.isEmpty()) {
                w += pq.remove().first;
            }
        }
        return w;
    }
}