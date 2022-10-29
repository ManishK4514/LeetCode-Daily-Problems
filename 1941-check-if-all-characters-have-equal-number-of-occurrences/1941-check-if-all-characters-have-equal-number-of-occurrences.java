class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++){
            map[s.charAt(i) - 'a']++;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < map.length; i++){
            if(map[i] != 0){
                set.add(map[i]);
            }
        }
        return set.size() == 1;
    }
}