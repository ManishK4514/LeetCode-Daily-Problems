class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(n > m){
            return findMedianSortedArrays(nums2, nums1);
        }
        int k = (n + m)/2;
        int low = Math.max(0,k-n), high = Math.min(k,m);
        while(low <= high){
            int cut1 = low + (high - low)/2;
            int cut2 = k - cut1;

            // edge cases

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1]; 
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = cut1 == m ? Integer.MAX_VALUE : nums1[cut1]; 
            int r2 = cut2 == n ? Integer.MAX_VALUE : nums2[cut2]; 
            
            if(l1 <= r2 && l2 <= r1){
                int mid = Integer.MAX_VALUE, mid1 = Integer.MIN_VALUE, mid2 = Integer.MAX_VALUE;
                if((m + n) % 2 == 0){
                    mid1 = Math.max(l1, l2);
                    mid2 = Math.min(r1, r2);
                    return (double)(mid1 + mid2)/2;
                }
                else{
                    mid = Math.min(r1, r2);
                    return (double)(mid);
                }
            }
            else if(l1 > r2){
                high = cut1 - 1;
            }
            else{
                low = cut1 + 1;
            }
        }
        return 1;
    }
}