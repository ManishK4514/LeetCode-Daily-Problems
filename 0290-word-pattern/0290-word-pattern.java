class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        int i = 0;
        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;
        for(char ch : pattern.toCharArray()){
            if(!map.containsKey(ch)){
                if(map.containsValue(words[i])) return false;
                map.put(ch, words[i]);
            }
            else{
                if(!map.get(ch).equals(words[i])) return false;
            }
            i++;
        }        
        return true;
    }
}