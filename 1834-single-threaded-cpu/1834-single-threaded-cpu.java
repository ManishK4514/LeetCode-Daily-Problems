class Pair{
    int enqueueTime;
    int processingTime;
    int idx;
    Pair(int enqueueTime, int processingTime, int idx){
        this.enqueueTime = enqueueTime;
        this.processingTime = processingTime;
        this.idx = idx;
    }
}
class Solution {
    public int[] getOrder(int[][] tasks) {
        Pair[] arr = new Pair[tasks.length];
        int i = 0;
        for(int[] nums : tasks){
            arr[i] = new Pair(nums[0], nums[1], i);
            i++;
        }
        Arrays.sort(arr, (a, b)->{            
            return a.enqueueTime - b.enqueueTime;
        });
        int time = 0;
        int[] res = new int[arr.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->{
            if(a.processingTime == b.processingTime){
                return a.idx - b.idx;
            }
            return a.processingTime - b.processingTime;
        });
        int j = 0;
        int k = 0;
        while(j < arr.length || !pq.isEmpty()){
            if(pq.isEmpty()){
                time = Math.max(time, arr[j].enqueueTime);
            }
            while(j < arr.length && arr[j].enqueueTime <= time){                    
                pq.add(arr[j]);
                j++;                    
            }
            Pair p = pq.remove();
            time += p.processingTime;
            res[k++] = p.idx;
        }
        return res;
    }
}