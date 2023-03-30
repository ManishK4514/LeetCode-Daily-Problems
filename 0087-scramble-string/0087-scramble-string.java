class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean helper(String s1, String s2){
        if(s1.equals(s2)) {
            map.put(s1 + "#" + s2, true);
            return true;
        }
        if(s1.length() == 1) return false;
        if(map.containsKey(s1 + "#" + s2)) return map.get(s1 + "#" + s2);
        for(int k = 1; k <= s1.length() - 1; k++){
            if (helper(s1.substring(0,k), s2.substring(0,k)) 
             && helper(s1.substring(k), s2.substring(k))) {
                map.put(s1 + "#" + s2, true);
                return true;
             }
            if (helper(s1.substring(0,k), s2.substring(s2.length()-k)) 
             && helper(s1.substring(k), s2.substring(0,s2.length()-k))) {
                map.put(s1 + "#" + s2, true);
                return true;
             }
        }
        map.put(s1 + "#" + s2, false);
        return false;
    }
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        return helper(s1, s2);
    }
}