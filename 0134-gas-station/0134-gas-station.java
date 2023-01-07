class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalFuel = 0;
        for(int i = 0; i < n; i++){
            totalFuel += gas[i];
        }
        int totalCost = 0;
        for(int i = 0; i < n; i++){
            totalCost += cost[i];
        }
        if(totalFuel < totalCost) return -1;
        int start = 0, currFuel = 0;
        for(int i = 0; i < n; i++){
            currFuel += gas[i];
            currFuel -= cost[i];
            if(currFuel < 0){
                currFuel = 0;
                start = i + 1;
            }
        }
        return start;
    }
}