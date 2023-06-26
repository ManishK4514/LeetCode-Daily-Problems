class Touple{
    int idx;
    int cost;
    int type;
    Touple(int idx, int cost, int type){
        this.idx = idx;
        this.cost = cost;
        this.type = type;
    }
}
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        PriorityQueue<Touple> pq = new PriorityQueue<>((a, b)->{
            if(a.cost == b.cost) return a.idx - b.idx;
            else return a.cost - b.cost;
        });

        int i = 0, j = n - 1, kk = candidates;
        while(i < j && kk--> 0){
            pq.add(new Touple(i, costs[i], 1));
            pq.add(new Touple(j, costs[j], 2));
            i++; j--;
        }
        if(i == j && kk > 0) {
            pq.add(new Touple(i, costs[i], 1));
            i++;
        }
        
        long ans = 0;
        while(k--> 0){
            Touple curr = pq.remove();
            
            ans += curr.cost;
            if(i < j && curr.type == 1){
                pq.add(new Touple(i, costs[i], 1));
                i++;
            }
            else if(i < j && curr.type == 2){
                pq.add(new Touple(j, costs[j], 2));
                j--;
            }
            else if(i == j){
                pq.add(new Touple(i, costs[i], 1));
                i++;
            }
        }

        return ans;
    }
}