class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            map.put(order.charAt(i), i);
        }
        for(int i = 0; i < n- 1; i++){
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            for(int j = 0; j < len; j++){
                if(map.get(w1.charAt(j)) < map.get(w2.charAt(j))) break;
                if(map.get(w1.charAt(j)) > map.get(w2.charAt(j))) return false;
                if(j == len - 1 && w1.length() > w2.length()) return false;
            }
        }
        return true;
    }
}