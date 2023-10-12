/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l = 0, r = mountainArr.length() - 1, peak = -1;
        int len = r + 1;

        while(l <= r) {
            int mid = l + (r - l)/2;
            int midVal = mountainArr.get(mid);
            
            if(mid == len - 1 && mountainArr.get(mid - 1) < midVal){
                peak = mid;
                break;
            }
            else if(mid - 1 >= 0 && mountainArr.get(mid - 1) < midVal && midVal > mountainArr.get(mid + 1)) {
                peak = mid;
                break;
            }

            if(mid - 1 >= 0 && mountainArr.get(mid) > mountainArr.get(mid - 1)) l = mid + 1;
            else r = mid - 1;
        }

        int left = search1(target, mountainArr, 0, peak);
        if(left >= 0 && left < len && mountainArr.get(left) == target) return left;

        int right = search2(target, mountainArr, peak, len - 1);
        if(right >= 0 && right < len && mountainArr.get(right) == target) return right;
        
        return -1;
    }

    public int search1(int target, MountainArray mountainArr, int l, int r) {
        while(l <= r) {
            int mid = l + (r - l)/2;
            int midVal = mountainArr.get(mid);

            if(midVal >= target) r = mid - 1;
            else l = mid + 1;
        }

        return l;
    }

    public int search2(int target, MountainArray mountainArr, int l, int r) {
        while(l <= r) {
            int mid = l + (r - l)/2;
            int midVal = mountainArr.get(mid);

            if(midVal >= target) l = mid + 1;
            else r = mid - 1;
        }

        return r;
    }
}