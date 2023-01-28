class SummaryRanges {
    ArrayList<Integer> nums;
    public SummaryRanges() {
        nums = new ArrayList<>();
    }
    
    public void addNum(int value) {
        nums.add(value);
        Collections.sort(nums);
    }
    
    public int[][] getIntervals() {
        int preN = nums.get(0);
        ArrayList<int[]> list = new ArrayList<>();
        int curr = preN;
        int n = preN;
        curr++; 
        boolean flag = true;       
        for(int i = 1; i < nums.size(); i++){
            if(nums.get(i) == n) continue;
            else if(curr < nums.get(i)){
                list.add(new int[]{preN, n});
                n = nums.get(i);
                preN = n;
                curr = n + 1;
            }
            else{
                n = nums.get(i);
                curr += 1;
            }
            flag = false;
        }
        if(!flag) list.add(new int[]{preN, curr - 1});
        if(nums.size() == 1) list.add(new int[]{n, n});
        if(list.size() == 0) list.add(new int[]{n, n});
        return convert(list);
    }
    public static int[][] convert(ArrayList<int[]> list){
        int n = list.size();
        int[][] ans = new int[n][2];
        int i = 0;
        for(int[] nums : list){
            ans[i++] = nums;
        }
        return ans;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */