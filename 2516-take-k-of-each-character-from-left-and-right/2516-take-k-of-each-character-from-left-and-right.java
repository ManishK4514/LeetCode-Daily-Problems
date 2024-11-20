class Solution {
    public boolean isValid(int[] map, int k) {
        return map[0] >= k && map[1] >= k && map[2] >= k;
    }
    public int takeCharacters(String s, int k) {
        int l = 0, r = 0, n = s.length(), max = 0;
        int[] map = new int[3];

        for(char ch : s.toCharArray()) map[ch - 'a']++;

        if(!isValid(map, k)) return -1;

        while(r < n) {
            map[s.charAt(r) - 'a']--;
            while(!isValid(map, k)) {
                map[s.charAt(l) - 'a']++;
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return n - max;
    }
}