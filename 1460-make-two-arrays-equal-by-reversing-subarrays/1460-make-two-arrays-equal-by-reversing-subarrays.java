class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n = arr.length;

        int[] map1 = new int[1001];
        int[] map2 = new int[1001];

        for(int i = 0; i < n; i++) {
            map1[target[i]]++;
            map2[arr[i]]++;
        }

        for(int i = 0; i < map1.length; i++) {
            if(map1[i] != map2[i]) return false;
        }

        return true;
    }
}