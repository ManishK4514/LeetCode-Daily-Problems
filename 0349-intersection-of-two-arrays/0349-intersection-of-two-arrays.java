class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int size = 1001;
        int[] set = new int[size];
        for(int it : nums1) set[it] = 1;

        int n = 0, idx = 0;

        for(int it : nums2) {
            if(set[it] == 1) {
                set[it] = 2;
                n++;
            }            
        }

        int[] ans = new int[n];

        // System.out.println(Arrays.toString(set));
        
        for(int i = 0; i < size; i++) {
            if(set[i] == 2) ans[idx++] = i;
        }

        return ans;
    }
}