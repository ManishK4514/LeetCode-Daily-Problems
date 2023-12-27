class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length(), totalTime = 0, max = neededTime[0], time = 0;
    
        for(int i = 0; i < n; i++) totalTime += neededTime[i];

        for(int i = 1; i < n; i++){
            if(colors.charAt(i) != colors.charAt(i - 1)){
                time += max;
                max = neededTime[i];
            }
            else {
                max = Math.max(max, neededTime[i]);
            }
        }

        time += max;

        return totalTime - time;
    }
}