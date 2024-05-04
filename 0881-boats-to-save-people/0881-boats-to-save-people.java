class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length, boats = 0; 
        int[] bucket = new int[30001];

        for(int it : people) bucket[it]++;

        int l = 0, r = bucket.length - 1, m = bucket.length;

        while(bucket[l] == 0) l++;
        while(bucket[r] == 0) r--;

        while(l < r) {            
            if(l + r > limit) {
                bucket[r]--;
                boats++;
            }
            else {
                bucket[l]--;
                bucket[r]--;
                boats++;
            }

            while(l < m && bucket[l] == 0) l++;
            while(r > 0 && bucket[r] == 0) r--;
        }

        if(l == r && bucket[l] > 0) {
            if(l * 2 <= limit) {
                boats += bucket[l]/2;
                if(bucket[l] % 2 != 0) boats++;
            }
            else boats += bucket[l];
        }

        return boats;
    }
}