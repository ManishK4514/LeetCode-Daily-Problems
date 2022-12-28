class Solution {
    public int minStoneSum(int[] piles, int k) {  
        int count = 0;   
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{return b - a;});
        for(int pile : piles){
            pq.add(pile);
            sum += pile;
        }
        while(count != k){
            int top = pq.remove();
            count++;
            sum -= top/2;
            top -= top / 2;            
            pq.add(top);
        } 
        return sum;
    }
}