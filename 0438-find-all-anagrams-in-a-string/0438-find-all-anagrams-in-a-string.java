class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())return false;
     
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
          freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
          freq[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
          if (freq[i] != 0)
            return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        for(int j = k; j <= s.length(); j++){
            boolean possible = isAnagram(s.substring(i, j), p);
            if(possible){
                ans.add(i);
            }
            i++;
        }
        return ans;
    }
}