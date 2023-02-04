class Solution { 
    public boolean equal(int[] mp1, int[] mp2){
        for(int i = 0; i < 26; i++){
            if(mp1[i] != mp2[i]) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] mp1 = new int[26];
        int[] mp2 = new int[26];
        int l = 0, r = 0, len = s1.length();
        while(r < len){
            mp1[s1.charAt(r) - 'a']++;
            mp2[s2.charAt(r) - 'a']++;
            r++;
        }
        if(equal(mp1, mp2)) return true;
        while(r < s2.length()){
            mp2[s2.charAt(r) - 'a']++;
            mp2[s2.charAt(l) - 'a']--;
            if(equal(mp1, mp2)) return true;
            r++; l++;
        }
        return false;
    }
}