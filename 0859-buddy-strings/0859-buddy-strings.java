class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;
        int count= 0;
        HashMap<Character, Character> map = new HashMap<>();
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != goal.charAt(i)){
                map.put(s.charAt(i), goal.charAt(i));
                count++;
            }
            freq[s.charAt(i) - 'a']++;
        }
        if(count > 2 || count == 1) return false;
        if(count == 2) {
            String a = "";
            String b = "";
            for (char key : map.keySet()) {
                a += key;
                b = map.get(key) + b;
            }
            if(a.equals(b)) return true;
            else return false;
        }
        // if count == 0
        for(int i = 0; i < 26; i++){
            if(freq[i] > 1) return true;
        }
        return false;
    }
}