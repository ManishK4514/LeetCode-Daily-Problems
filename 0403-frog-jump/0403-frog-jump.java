class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1] - stones[0] != 1) return false;
        if(stones.length == 1){
            if(stones[1] - stones[0] == 1) return true;
        }
        HashMap<Integer, HashSet<Integer>> dp=new HashMap<>();
        for(int x:stones){
            dp.put(x, new HashSet<>());
        }
        dp.get(0).add(0);
        for(int x:stones){
            for(int k:dp.get(x)){
                if(k - 1>0&&dp.containsKey(x + k - 1)){
                    dp.get(x + k - 1).add(k - 1);
                }
                if(dp.containsKey(x + k)){
                    dp.get(x + k).add(k);
                }
                if(dp.containsKey(x + k + 1)){
                    dp.get(x + k + 1).add(k + 1);
                }
            }
        }
        return dp.get(stones[stones.length - 1]).size()>0;
    }
}