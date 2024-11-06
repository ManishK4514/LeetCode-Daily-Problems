class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ls = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int prev = Integer.bitCount(nums[0]);
        temp.add(nums[0]);
        for(int i = 1; i < n; i++) {
            int bitCnt = Integer.bitCount(nums[i]);            
            if(bitCnt == prev) {
                temp.add(nums[i]);
            }
            else {
                prev = bitCnt;
                Collections.sort(temp);
                for(int it : temp) ls.add(it);       
                temp.clear();
                temp.add(nums[i]);
            }
            
        }
        
        if(temp.size() > 0) {
            Collections.sort(temp);
            for(int it : temp) ls.add(it);  
        }
        
        
        for(int i = 1; i < n; i++) {
            if(ls.get(i) < ls.get(i - 1)) return false;
        }
        
        
        return true;
    }
}