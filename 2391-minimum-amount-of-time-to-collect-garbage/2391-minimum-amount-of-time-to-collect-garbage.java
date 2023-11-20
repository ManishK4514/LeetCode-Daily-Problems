class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length, metalCost = 0, glassCost = 0, paperCost = 0;
        int ans = 0;

        for(int i = 0; i < n; i++) {   
            int paper = 0, metal = 0, glass = 0;
            for(int j = 0; j < garbage[i].length(); j++) {
                if(garbage[i].charAt(j) == 'P') paper++;
                else if(garbage[i].charAt(j) == 'G') glass++;
                else metal++;
            }

            if(i == 0) {
                ans += paper + metal + glass;
                continue;                
            }

            metalCost += travel[i - 1];
            glassCost += travel[i - 1];
            paperCost += travel[i - 1];

            if(paper != 0) {
                ans += paperCost + paper;
                paperCost = 0;
            }

            if(metal != 0) {
                ans += metalCost + metal;
                metalCost = 0;
            }

            if(glass != 0) {
                ans += glassCost + glass;
                glassCost = 0;
            }
            
        }  

        return ans;      
    }
}