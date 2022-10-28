class Solution {
    public static boolean check(int[] phash, int[] hash){
        for(int i = 0; i < phash.length; i++){
            if(phash[i] != hash[i]){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s.length() < p.length()){
            return ans;            
        }
        int[] phash = new int[26];
        int[] hash = new int[26];
        int left = 0, right = 0, window = p.length();
        while(right < window){
            phash[p.charAt(right) - 'a']++;
            hash[s.charAt(right) - 'a']++;
            right++;
        }
        right -=1;
        while(right < s.length())
        {            
            boolean equal = check(phash, hash);
            if(equal)
            {
                ans.add(left);
            }
            right+=1;
            if(right != s.length())
            {
                hash[s.charAt(right) - 'a'] += 1;
            }
            hash[s.charAt(left) - 'a'] -=1 ;
            left += 1;
        }
        return ans;
    }
}
