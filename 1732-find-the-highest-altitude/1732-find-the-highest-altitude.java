class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0, currAltitude = 0;
        for(int i = 0; i < gain.length; i++){
            currAltitude += gain[i];
            maxAltitude = Math.max(maxAltitude, currAltitude);
        }
        return maxAltitude;
    }
}